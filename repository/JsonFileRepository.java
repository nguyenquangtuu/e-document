package repository;

import model.Document;
import model.DocumentBuilder;
import model.DocumentStatus;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

// Luu tru ho so duoi dang file JSON va file vat ly tren o dia
public class JsonFileRepository implements DocumentRepository {
    private final String storageDirPath;

    public JsonFileRepository() {
        this("server_storage");
    }

    public JsonFileRepository(String storageDirPath) {
        this.storageDirPath = storageDirPath;
        File dir = new File(storageDirPath);
        if (!dir.exists()) dir.mkdirs();
    }

    @Override
    public void save(Document doc) throws Exception {
        if (doc == null || doc.getId() == null) return;

        File dir = new File(storageDirPath);
        if (!dir.exists()) dir.mkdirs();

        // Sao chep file dinh kem neu co
        if (doc.getFilePath() != null && !doc.getFilePath().trim().isEmpty()) {
            File sourceFile = new File(doc.getFilePath());
            if (sourceFile.exists()) {
                Path targetPath = Paths.get(storageDirPath, doc.getId() + "_" + sourceFile.getName());
                Files.copy(sourceFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }

        // Xuat thong tin ho so ra file JSON
        String json = toJson(doc);
        File dataFile = new File(storageDirPath, doc.getId() + "_data.json");
        try (FileWriter writer = new FileWriter(dataFile)) {
            writer.write(json);
        }
        System.out.println("Luu ho so " + doc.getId() + " vao file: " + dataFile.getPath());
    }

    @Override
    public Document findById(String id) throws Exception {
        if (id == null) return null;
        File dataFile = new File(storageDirPath, id + "_data.json");
        if (!dataFile.exists()) return null;
        String content = new String(Files.readAllBytes(dataFile.toPath()));
        return fromJson(content);
    }

    @Override
    public List<Document> findAll() throws Exception {
        List<Document> list = new ArrayList<>();
        File dir = new File(storageDirPath);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((d, name) -> name.endsWith("_data.json"));
            if (files != null) {
                for (File f : files) {
                    try {
                        String content = new String(Files.readAllBytes(f.toPath()));
                        Document doc = fromJson(content);
                        if (doc != null) list.add(doc);
                    } catch (Exception ignored) {}
                }
            }
        }
        return list;
    }

    @Override
    public void delete(String id) throws Exception {
        if (id != null) {
            File dataFile = new File(storageDirPath, id + "_data.json");
            if (dataFile.exists()) dataFile.delete();
        }
    }

    @Override
    public boolean exists(String id) throws Exception {
        if (id == null) return false;
        return new File(storageDirPath, id + "_data.json").exists();
    }

    // Ham chuyen doi Document sang JSON
    public static String toJson(Document doc) {
        if (doc == null) return "{}";
        return "{\n" +
                "  \"id\": \"" + safeStr(doc.getId()) + "\",\n" +
                "  \"applicantName\": \"" + safeStr(doc.getApplicantName()) + "\",\n" +
                "  \"applicantEmail\": \"" + safeStr(doc.getApplicantEmail()) + "\",\n" +
                "  \"applicantPhone\": \"" + safeStr(doc.getApplicantPhone()) + "\",\n" +
                "  \"officerName\": \"" + safeStr(doc.getOfficerName()) + "\",\n" +
                "  \"officerEmail\": \"" + safeStr(doc.getOfficerEmail()) + "\",\n" +
                "  \"officerPhone\": \"" + safeStr(doc.getOfficerPhone()) + "\",\n" +
                "  \"documentType\": \"" + safeStr(doc.getDocumentType()) + "\",\n" +
                "  \"filePath\": \"" + safeStr(doc.getFilePath()).replace("\\", "\\\\") + "\",\n" +
                "  \"fileExtension\": \"" + safeStr(doc.getFileExtension()) + "\",\n" +
                "  \"fileSizeKB\": " + doc.getFileSizeKB() + ",\n" +
                "  \"digitalSignature\": \"" + safeStr(doc.getDigitalSignature()) + "\",\n" +
                "  \"status\": \"" + doc.getStatusName() + "\"\n" +
                "}";
    }

    // Ham parse JSON ve Document
    public static Document fromJson(String json) {
        if (json == null || json.trim().isEmpty()) return null;
        try {
            String id = extract(json, "id");
            String applicantName = extract(json, "applicantName");
            String applicantEmail = extract(json, "applicantEmail");
            String applicantPhone = extract(json, "applicantPhone");
            String officerName = extract(json, "officerName");
            String officerEmail = extract(json, "officerEmail");
            String officerPhone = extract(json, "officerPhone");
            String documentType = extract(json, "documentType");
            String filePath = extract(json, "filePath");
            String fileExtension = extract(json, "fileExtension");
            String sizeStr = extract(json, "fileSizeKB");
            long fileSizeKB = (sizeStr != null && !sizeStr.isEmpty()) ? Long.parseLong(sizeStr) : 0L;
            String digitalSignature = extract(json, "digitalSignature");
            String status = extract(json, "status");

            return new DocumentBuilder()
                    .setId(id)
                    .setApplicantInfo(applicantName, applicantEmail, applicantPhone)
                    .setOfficerInfo(officerName, officerEmail, officerPhone)
                    .setDocumentInfo(documentType)
                    .setFileInfo(filePath, fileExtension, fileSizeKB)
                    .setSecurityInfo(digitalSignature)
                    .setStatus(DocumentStatus.fromString(status))
                    .build();
        } catch (Exception e) {
            return null;
        }
    }

    private static String safeStr(String s) { return (s != null) ? s : ""; }

    private static String extract(String json, String key) {
        String p = "\"" + key + "\":";
        int i = json.indexOf(p);
        if (i == -1) {
            p = "\"" + key + "\" :";
            i = json.indexOf(p);
            if (i == -1) return null;
        }
        int start = i + p.length();
        while (start < json.length() && Character.isWhitespace(start)) start++;
        if (start >= json.length()) return null;

        if (json.charAt(start) == '\"') {
            start++;
            int end = json.indexOf('\"', start);
            return (end != -1) ? json.substring(start, end) : null;
        } else {
            int end = start;
            while (end < json.length() && json.charAt(end) != ',' && json.charAt(end) != '}' && json.charAt(end) != '\n') {
                end++;
            }
            return json.substring(start, end).trim();
        }
    }
}
