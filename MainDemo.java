import extractor.ContentExtractor;
import extractor.ExtractorFactory;
import model.Document;
import model.DocumentBuilder;
import model.DocumentStatus;
import service.DocumentProcessor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Chuong trinh demo 3 kich ban xu ly ho so
public class MainDemo {

    public static void main(String[] args) {
        System.out.println("DEMO HE THONG XU LY HO SO v2.0\n");

        File sampleFile = createTempFile("don_xin_phep.txt", "Kinh gui Ban Giam hieu, toi xin phep nghi hoc.");

        try {
            // Test 1: Ho so hop le
            runScenario1_HappyPath(sampleFile);

            // Test 2: Ho so thieu thong tin
            runScenario2_FailValidation(sampleFile);

            // Test 3: Doc nhieu loai file
            runScenario3_MultiFormat();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ho so hop le day du cac truong
    private static void runScenario1_HappyPath(File file) {
        System.out.println("1. Kiem tra ho so hop le:");

        Document doc = new DocumentBuilder()
                .setId("DOC01")
                .setApplicantInfo("Nguyen Van An", "an.nv@gmail.com", "0901234567")
                .setOfficerInfo("Can bo truc ban", "officer@tdtu.edu.vn", "0123456789")
                .setDocumentInfo("DON_XIN_PHEP")
                .setFileInfo(file.getAbsolutePath(), "txt", 1024)
                .setSecurityInfo("RSA_OK")
                .setStatus(DocumentStatus.MOI_TAO)
                .build();

        DocumentProcessor processor = new DocumentProcessor();
        processor.process(doc);

        System.out.println("=> Ket qua: " + doc.getStatus().getDisplayName() + "\n");
    }

    // Ho so luu nhap chua du thong tin
    private static void runScenario2_FailValidation(File file) {
        System.out.println("2. Kiem tra ho so thieu thong tin:");

        Document draftDoc = new DocumentBuilder()
                .setId("DOC02")
                .setApplicantInfo("Tran Thi Bich", "bich.tt@gmail.com", "0912345678")
                .setFileInfo(file.getAbsolutePath(), "txt", 500)
                .setStatus(DocumentStatus.MOI_TAO)
                .build();

        DocumentProcessor processor = new DocumentProcessor();
        processor.process(draftDoc);

        System.out.println("=> Ket qua: " + draftDoc.getStatus().getDisplayName() + "\n");
    }

    // Doc cac loai file txt, pdf, jpg
    private static void runScenario3_MultiFormat() {
        System.out.println("3. Kiem tra doc da dinh dang file:");

        String[] extensions = {"txt", "pdf", "jpg"};
        for (String ext : extensions) {
            ContentExtractor extractor = ExtractorFactory.getExtractor(ext);
            try {
                File temp = createTempFile("test." + ext, "Noi dung mau " + ext);
                String result = extractor.extract(temp.getAbsolutePath());
                System.out.println("- File ." + ext + " (" + extractor.getClass().getSimpleName() + "): " + result);
            } catch (IOException e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }
    }

    private static File createTempFile(String name, String content) {
        try {
            File f = new File(System.getProperty("java.io.tmpdir"), name);
            try (FileWriter w = new FileWriter(f)) {
                w.write(content);
            }
            f.deleteOnExit();
            return f;
        } catch (IOException e) {
            return new File(name);
        }
    }
}
