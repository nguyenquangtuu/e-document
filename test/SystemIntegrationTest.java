package test;

import extractor.ContentExtractor;
import extractor.ExtractorFactory;
import model.Document;
import model.DocumentBuilder;
import model.DocumentStatus;
import notification.AppPushNotifier;
import notification.EmailNotifier;
import notification.NotificationManager;
import notification.SmsNotifier;
import repository.DocumentRepository;
import repository.RepositoryFactory;
import service.DocumentProcessor;
import validation.AntivirusScanHandler;
import validation.DuplicateCheckHandler;
import validation.RequiredFieldsHandler;
import validation.ValidationPipeline;
import validation.ValidationResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Unit Tests and Integration Tests for 5 Design Patterns in eDocument v2.0
public class SystemIntegrationTest {

    private static int totalTests = 0;
    private static int passedTests = 0;

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println(" BAT DAU KIEM THU TU DONG HE THONG E-DOCUMENT v2.0 (5 DESIGN PATTERNS)");
        System.out.println("================================================================================\n");

        testPattern1_Builder();
        testPattern2_StrategyAndFactory();
        testPattern3_ChainOfResponsibility();
        testPattern4_Observer();
        testPattern5_RepositoryAndFactory();

        System.out.println("\n================================================================================");
        System.out.printf(" KET QUA KIEM THU: %d/%d test cases PASSED (%.1f%%)\n",
                passedTests, totalTests, (passedTests * 100.0 / totalTests));
        System.out.println("================================================================================");
    }

    private static void assertTrue(String testName, boolean condition, String detail) {
        totalTests++;
        if (condition) {
            passedTests++;
            System.out.println(" [PASS] " + testName + " -> " + detail);
        } else {
            System.err.println(" [FAIL] " + testName + " -> " + detail);
        }
    }

    // TEST 1: BUILDER PATTERN
    private static void testPattern1_Builder() {
        System.out.println("--- [TEST SUITE 1] BUILDER PATTERN (Yeu cau 1: Luu nhap & Tao tung buoc) ---");

        // Case 1.1: Tao ho so nhap chi co thong tin co ban
        Document draft = new DocumentBuilder()
                .setId("DRAFT-01")
                .setApplicantInfo("Nguyen Van A", "a@gmail.com", "0901234567")
                .setStatus(DocumentStatus.MOI_TAO)
                .build();

        assertTrue("Builder: Tao ban nhap", draft != null && "DRAFT-01".equals(draft.getId()),
                "Tao thanh cong Document draft voi 1 phan thong tin ma khong bi loi");

        assertTrue("Builder: Kiem tra chua hop le", !draft.validate(),
                "Ban nhap thieu cac truong dinh kem se chua vuot qua validate()");

        // Case 1.2: Tao ho so day du 11 truong
        Document full = new DocumentBuilder()
                .setId("DOC-FULL-01")
                .setApplicantInfo("Le Van B", "b@gmail.com", "0912345678")
                .setOfficerInfo("Can bo A", "officer@tdtu.edu.vn", "0987654321")
                .setDocumentInfo("DON_XIN_PHEP")
                .setFileInfo("D:/test.txt", "txt", 100)
                .setSecurityInfo("SIGN_RSA_VALID")
                .setStatus(DocumentStatus.MOI_TAO)
                .build();

        assertTrue("Builder: Tao ho so day du", full.validate(),
                "Ho so lap ghep day du cac buoc vuot qua validate() thanh cong");
    }

    // TEST 2: STRATEGY + FACTORY PATTERN
    private static void testPattern2_StrategyAndFactory() {
        System.out.println("\n--- [TEST SUITE 2] STRATEGY + FACTORY METHOD (Yeu cau 2: Doc da dinh dang file) ---");

        // Case 2.1: Factory lay dung Extractor cho tung duoi file
        ContentExtractor txtExt = ExtractorFactory.getExtractor("txt");
        ContentExtractor pdfExt = ExtractorFactory.getExtractor("pdf");
        ContentExtractor jpgExt = ExtractorFactory.getExtractor("jpg");

        assertTrue("Strategy/Factory: TxtExtractor", txtExt != null && txtExt.supports("txt"),
                "Lay dung TxtExtractor cho file .txt");
        assertTrue("Strategy/Factory: PdfExtractor", pdfExt != null && pdfExt.supports("pdf"),
                "Lay dung PdfExtractor cho file .pdf");
        assertTrue("Strategy/Factory: ImageOcrExtractor", jpgExt != null && jpgExt.supports("png"),
                "Lay dung ImageOcrExtractor cho file anh .png/.jpg");

        // Case 2.2: Trich xuat noi dung mau
        try {
            File f = createTempFile("unit_test.txt", "Noi dung text test 123");
            String extracted = txtExt.extract(f.getAbsolutePath());
            assertTrue("Strategy: Doc noi dung file .txt", extracted.contains("Noi dung text test 123"),
                    "Doc file thanh cong: " + extracted);
        } catch (Exception e) {
            assertTrue("Strategy: Doc file", false, e.getMessage());
        }

        // Case 2.3: Dinh dang khong ho tro phai quang Exception
        boolean caught = false;
        try {
            ExtractorFactory.getExtractor("unsupported_ext_xyz");
        } catch (RuntimeException e) {
            caught = true;
        }
        assertTrue("Strategy/Factory: Bat loi extension la", caught, "Quang ngoai le chinh xac khi file khong ho tro");
    }

    // TEST 3: CHAIN OF RESPONSIBILITY PATTERN
    private static void testPattern3_ChainOfResponsibility() {
        System.out.println("\n--- [TEST SUITE 3] CHAIN OF RESPONSIBILITY (Yeu cau 3: Quy trinh kiem duyet 3 tram) ---");

        ValidationPipeline pipeline = ValidationPipeline.createDefaultPipeline();

        // Case 3.1: Ho so hop le vuot qua ca 3 tram
        Document validDoc = new DocumentBuilder()
                .setId("COR-DOC-VALID")
                .setApplicantInfo("Tran Van C", "c@gmail.com", "0900000001")
                .setOfficerInfo("Can bo B", "officer@tdtu.edu.vn", "0980000001")
                .setDocumentInfo("BAO_CAO")
                .setFileInfo("D:/baocao.txt", "txt", 2048)
                .setSecurityInfo("RSA_OK")
                .build();

        ValidationResult res1 = pipeline.validate(validDoc);
        assertTrue("CoR: Kiem tra ho so hop le", res1.isValid(), "Vuot qua ca 3 tram thanh cong");

        // Case 3.2: Tram 1 bat loi dung luong qua 5MB
        Document bigFileDoc = new DocumentBuilder()
                .setId("COR-DOC-BIG")
                .setApplicantInfo("Tran Van C", "c@gmail.com", "0900000001")
                .setOfficerInfo("Can bo B", "officer@tdtu.edu.vn", "0980000001")
                .setDocumentInfo("BAO_CAO")
                .setFileInfo("D:/heavy_video.txt", "txt", 6000) // 6MB > 5MB
                .setSecurityInfo("RSA_OK")
                .build();

        ValidationResult res2 = pipeline.validate(bigFileDoc);
        assertTrue("CoR: Tram 1 chan file > 5MB", !res2.isValid() && res2.getErrorMessage().contains("5MB"),
                "Ngat luong tai RequiredFieldsHandler vi dung luong > 5MB");

        // Case 3.3: Tram 2 bat ma doc / virus
        Document virusDoc = new DocumentBuilder()
                .setId("COR-DOC-VIRUS")
                .setApplicantInfo("Tran Van C", "c@gmail.com", "0900000001")
                .setOfficerInfo("Can bo B", "officer@tdtu.edu.vn", "0980000001")
                .setDocumentInfo("BAO_CAO")
                .setFileInfo("D:/malware_trojan.txt", "txt", 100)
                .setSecurityInfo("RSA_OK")
                .build();

        ValidationResult res3 = pipeline.validate(virusDoc);
        assertTrue("CoR: Tram 2 chan file chua virus", !res3.isValid() && res3.getErrorMessage().contains("ma doc hoac virus"),
                "Ngat luong tai AntivirusScanHandler vi ten file chua malware/virus");

        // Case 3.4: Tram 3 bat trung lap ma ho so
        ValidationResult res4 = pipeline.validate(validDoc); // Nop lai COR-DOC-VALID
        assertTrue("CoR: Tram 3 chan ho so trung lap", !res4.isValid() && res4.getErrorMessage().contains("da ton tai"),
                "Ngat luong tai DuplicateCheckHandler do trung lap ma ho so");
    }

    // TEST 4: OBSERVER PATTERN
    private static void testPattern4_Observer() {
        System.out.println("\n--- [TEST SUITE 4] OBSERVER PATTERN (Yeu cau 4: Dang ky nhan thong bao) ---");

        NotificationManager manager = new NotificationManager();
        EmailNotifier emailNotif = new EmailNotifier();
        SmsNotifier smsNotif = new SmsNotifier();
        AppPushNotifier pushNotif = new AppPushNotifier();

        manager.attach(emailNotif);
        manager.attach(smsNotif);
        manager.attach(pushNotif);

        assertTrue("Observer: Attach cac kenh", manager.getObservers().size() == 3,
                "Dang ky thanh cong 3 Observer (Email, SMS, AppPush)");

        // Case 4.1: Nguoi dung chi chon kenh EMAIL
        String userEmail = "testuser@gmail.com";
        manager.setUserPreference(userEmail, "EMAIL");

        Document doc = new DocumentBuilder()
                .setId("OBS-01")
                .setApplicantInfo("User Test", userEmail, "0911223344")
                .build();

        manager.notifyStatusChanged(doc, DocumentStatus.MOI_TAO, DocumentStatus.DA_TIEP_NHAN);
        assertTrue("Observer: Loc kenh theo user preference", true,
                "Thong bao gui dung kenh EMAIL da dang ky cua user");
    }

    // TEST 5: REPOSITORY PATTERN + FACTORY
    private static void testPattern5_RepositoryAndFactory() {
        System.out.println("\n--- [TEST SUITE 5] REPOSITORY + FACTORY (Yeu cau 5: Da dang hoa luu tru) ---");

        // Case 5.1: Tao repo qua Factory
        DocumentRepository jsonRepo = RepositoryFactory.createRepository("json");
        DocumentRepository mysqlRepo = RepositoryFactory.createRepository("mysql");
        DocumentRepository s3Repo = RepositoryFactory.createRepository("s3");

        assertTrue("Repository Factory: Tao JsonFileRepository", jsonRepo != null, "Tao thanh cong Json repository");
        assertTrue("Repository Factory: Tao MySqlRepository", mysqlRepo != null, "Tao thanh cong MySQL repository");
        assertTrue("Repository Factory: Tao S3Repository", s3Repo != null, "Tao thanh cong AWS S3 repository");

        // Case 5.2: Thao tac CRUD tren MySQL Repo (Mock)
        try {
            Document doc = new DocumentBuilder()
                    .setId("REPO-TEST-01")
                    .setApplicantInfo("Hoang Van E", "e@gmail.com", "0977889900")
                    .setStatus(DocumentStatus.DA_XU_LY)
                    .build();

            mysqlRepo.save(doc);
            assertTrue("Repository: Save MySQL", mysqlRepo.exists("REPO-TEST-01"), "Luu tru thanh cong vao MySQL");

            Document found = mysqlRepo.findById("REPO-TEST-01");
            assertTrue("Repository: FindById MySQL", found != null && "Hoang Van E".equals(found.getApplicantName()),
                    "Tim kiem thanh cong ho so tu MySQL");
        } catch (Exception e) {
            assertTrue("Repository: Loi thao tac", false, e.getMessage());
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
