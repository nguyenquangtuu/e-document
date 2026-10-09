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
        System.out.println("CHUONG TRINH DEMO HE THONG E-DOCUMENT v2.0");

        File sampleFile = createTempFile("don_xin_phep.txt", "Kinh gui Ban Giam hieu, toi xin phep nghi hoc.");

        try {
            // Kich ban 1: Ho so hop le
            runScenario1_HappyPath(sampleFile);

            // Kich ban 2: Ho so thieu thong tin
            runScenario2_FailValidation(sampleFile);

            // Kich ban 3: Trich xuat da dinh dang file
            runScenario3_MultiFormat();

        } catch (Exception e) {
            System.out.println("Loi demo: " + e.getMessage());
        }

        System.out.println("\nHoan tat chay 3 kich ban demo.");
    }

    // Kich ban 1: Ho so hop le day du 11 truong, file txt
    private static void runScenario1_HappyPath(File file) {
        System.out.println("\n--- Kich ban 1: Ho so hop le ---");

        // Dung Builder de tao ho so
        Document doc = new DocumentBuilder()
                .setId("DOC-001")
                .setApplicantInfo("Nguyen Van An", "an.nv@gmail.com", "0901234567")
                .setOfficerInfo("Can bo truc ban", "officer@tdtu.edu.vn", "0123456789")
                .setDocumentInfo("DON_XIN_PHEP")
                .setFileInfo(file.getAbsolutePath(), "txt", 1024)
                .setSecurityInfo("CHUKYSO_RSA_OK")
                .setStatus(DocumentStatus.MOI_TAO)
                .build();

        DocumentProcessor processor = new DocumentProcessor();
        processor.process(doc);

        System.out.println("Ket qua: Trang thai = " + doc.getStatus().getDisplayName());
    }

    // Kich ban 2: Ho so luu nhap thieu truong bat buoc
    private static void runScenario2_FailValidation(File file) {
        System.out.println("\n--- Kich ban 2: Ho so thieu thong tin ---");

        // Ho so chi co thong tin nguoi nop, thieu can bo va chu ky so
        Document draftDoc = new DocumentBuilder()
                .setId("DOC-DRAFT-002")
                .setApplicantInfo("Tran Thi Bich", "bich.tt@gmail.com", "0912345678")
                .setFileInfo(file.getAbsolutePath(), "txt", 500)
                .setStatus(DocumentStatus.MOI_TAO)
                .build();

        DocumentProcessor processor = new DocumentProcessor();
        processor.process(draftDoc);

        System.out.println("Ket qua: Trang thai = " + draftDoc.getStatus().getDisplayName());
    }

    // Kich ban 3: Doc cac loai file txt, pdf, jpg qua Strategy + Factory
    private static void runScenario3_MultiFormat() {
        System.out.println("\n--- Kich ban 3: Doc da dinh dang file ---");

        String[] extensions = {"txt", "pdf", "jpg"};
        for (String ext : extensions) {
            ContentExtractor extractor = ExtractorFactory.getExtractor(ext);
            System.out.println("File ." + ext + " duoc xu ly boi: " + extractor.getClass().getSimpleName());
            try {
                File temp = createTempFile("test." + ext, "Noi dung mau " + ext);
                String result = extractor.extract(temp.getAbsolutePath());
                System.out.println("  Noi dung doc duoc: " + result);
            } catch (IOException e) {
                System.out.println("  Loi: " + e.getMessage());
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
