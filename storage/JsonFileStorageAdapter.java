package storage;

import model.Document;
import model.DocumentStatus;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter 1 trong Adapter Pattern (Chuong 8 - Course Syllabus 504077):
 * Chuyen doi (Adapt) he thong tap tin JSON cuc bo sang giao tiep tieu chuan DocumentStorageTarget.
 */
public class JsonFileStorageAdapter implements DocumentStorageTarget {
    private final String storageDirPath;

    public JsonFileStorageAdapter() {
        this("server_storage");
    }

    public JsonFileStorageAdapter(String storageDirPath) {
        this.storageDirPath = storageDirPath;
        File dir = new File(storageDirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    @Override
    public String getStorageName() {
        return "Local JSON File Storage";
    }

    @Override
    public void save(Document doc) throws Exception {
        if (doc == null || doc.getId() == null) return;

        File dir = new File(storageDirPath);
        if (!dir.exists()) dir.mkdirs();

        // Sao chep tap tin dinh kem neu co
        if (doc.getFilePath() != null && !doc.getFilePath().trim().isEmpty()) {
            File sourceFile = new File(doc.getFilePath());
            if (sourceFile.exists()) {
                Path targetPath = Paths.get(storageDirPath, doc.getId() + "_" + sourceFile.getName());
                Files.copy(sourceFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }

        // Ghi thong tin ho so ra file JSON
        String json = toJson(doc);
        File dataFile = new File(storageDirPath, doc.getId() + "_data.json");
        try (FileWriter writer = new FileWriter(dataFile)) {
            writer.write(json);
        }
        System.out.println("[JsonStorageAdapter] Da luu ho so " + doc.getId() + " vao: " + dataFile.getPath());
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

    @Override
    public int count() throws Exception {
        return findAll().size();
    }

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
                "  \"extractedContent\": \"" + safeStr(doc.getExtractedContent()).replace("\n", " ").replace("\"", "'") + "\",\n" +
                "  \"status\": \"" + doc.getStatusName() + "\"\n" +
                "}";
    }

    public static Document fromJson(String json) {
        if (json == null || json.trim().isEmpty()) return null;
        try {
            Document doc = new Document();
            doc.setId(extract(json, "id"));
            doc.setApplicantName(extract(json, "applicantName"));
            doc.setApplicantEmail(extract(json, "applicantEmail"));
            doc.setApplicantPhone(extract(json, "applicantPhone"));
            doc.setOfficerName(extract(json, "officerName"));
            doc.setOfficerEmail(extract(json, "officerEmail"));
            doc.setOfficerPhone(extract(json, "officerPhone"));
            doc.setDocumentType(extract(json, "documentType"));
            doc.setFilePath(extract(json, "filePath"));
            doc.setFileExtension(extract(json, "fileExtension"));
            String sizeStr = extract(json, "fileSizeKB");
            doc.setFileSizeKB((sizeStr != null && !sizeStr.isEmpty()) ? Long.parseLong(sizeStr) : 0L);
            doc.setDigitalSignature(extract(json, "digitalSignature"));
            doc.setExtractedContent(extract(json, "extractedContent"));
            String status = extract(json, "status");
            doc.setStatus(DocumentStatus.fromString(status));
            return doc;
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
