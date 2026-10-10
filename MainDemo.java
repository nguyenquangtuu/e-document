import command.ApproveDocumentCommand;
import command.DocumentCommandInvoker;
import command.SubmitDocumentCommand;
import extractor.ContentExtractor;
import extractor.ExtractorFactory;
import model.Document;
import model.DocumentStatus;
import notification.NotificationManager;
import service.DocumentProcessor;
import storage.AwsS3StorageAdapter;
import storage.DocumentStorageTarget;
import storage.JsonFileStorageAdapter;
import storage.MySqlStorageAdapter;
import storage.StorageAdapterFactory;
import validation.StandardDocumentValidator;
import validation.StrictSecurityValidator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Chuong trinh Demo Tong hop 5 Kich ban thuc nghiem tren Console
 * Tuong ung truc tiep voi cac Mau Thiet Ke trong De cuong mon hoc (Course Syllabus 504077):
 * 1. Singleton Pattern (Chuong 2) & Template Method Pattern (Chuong 4)
 * 2. Template Method Pattern voi Hook Method & Hollywood Principle (Chuong 4)
 * 3. Strategy Pattern (Chuong 3) & Factory Method Pattern (Chuong 5)
 * 4. Adapter Pattern tich hop Da nguon luu tru (Chuong 8)
 * 5. Command Pattern voi Hoan tac (Undo/Redo) va Audit Logging (Chuong 7)
 */
public class MainDemo {

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("   HE THONG TIEP NHAN VA XU LY HO SO DIEN TU (eDocument v2.0)");
        System.out.println("   DEMO CUNG CO CAC MAU THIET KE GOF CHUAN DE CUONG MON HOC TDTU 504077");
        System.out.println("================================================================================\n");

        File sampleFile = createTempFile("don_xin_phep.txt", "Kinh gui Ban Giam hieu TDTU, em xin phep nghi hoc vi ly do ca nhan.");

        try {
            // Kich ban 1: Template Method Pattern & Singleton Pattern
            runScenario1_TemplateMethodAndSingleton(sampleFile);

            // Kich ban 2: Template Method Hook & Kiem duyet nghiem ngat
            runScenario2_StrictValidationHook();

            // Kich ban 3: Strategy & Factory Method - Doc da dinh dang
            runScenario3_StrategyAndFactory();

            // Kich ban 4: Adapter Pattern - Chuyen doi luu tru JSON / MySQL / AWS S3
            runScenario4_AdapterStorage();

            // Kich ban 5: Command Pattern - Thuc thi, Phe duyet, Hoan tac (Undo) & Audit Logging
            runScenario5_CommandPatternUndo();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n================================================================================");
        System.out.println("   KET THUC TOAN BO KICH BAN KIEM THU THUC NGHIEM - HOAN TAT!");
        System.out.println("================================================================================");
    }

    // Kich ban 1: Template Method Pattern (Standard) + Singleton Notification
    private static void runScenario1_TemplateMethodAndSingleton(File file) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("1. KICH BAN 1: XU LY HO SO HOP LE (TEMPLATE METHOD + SINGLETON PATTERN)");
        System.out.println("--------------------------------------------------------------------------------");

        // Singleton NotificationManager (Chuong 2)
        NotificationManager notif1 = NotificationManager.getInstance();
        NotificationManager notif2 = NotificationManager.getInstance();
        System.out.println("[Singleton Check] notif1 == notif2: " + (notif1 == notif2) + " (Xac nhan chi co 1 instance duy nhat)");

        // Cau hinh user preference nhan email & sms
        notif1.setUserPreference("an.nv@gmail.com", "EMAIL", "SMS");

        Document doc = new Document(
                "DOC01",
                "Nguyen Van An", "an.nv@gmail.com", "0901234567",
                "Can bo truc ban", "officer@tdtu.edu.vn", "0123456789",
                "DON_XIN_PHEP",
                file.getAbsolutePath(), "txt", 1024,
                "RSA_VALID_SIGNATURE_01"
        );

        // Khoi tao DocumentProcessor voi StandardDocumentValidator (Template Method)
        DocumentProcessor processor = new DocumentProcessor(new StandardDocumentValidator(), StorageAdapterFactory.getDefaultAdapter());
        processor.process(doc);

        System.out.println("=> Ket qua cuoi cung: " + doc.getStatus().getDisplayName() + "\n");
    }

    // Kich ban 2: Template Method voi Hook Method (StrictSecurityValidator)
    private static void runScenario2_StrictValidationHook() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("2. KICH BAN 2: HOOK METHOD & HOLLYWOOD PRINCIPLE (TEMPLATE METHOD PATTERN)");
        System.out.println("--------------------------------------------------------------------------------");

        // Tao ho so khong co chu ky so RSA
        Document insecureDoc = new Document(
                "DOC02",
                "Tran Thi Bich", "bich.tt@gmail.com", "0912345678",
                "Can bo truc ban", "officer@tdtu.edu.vn", "0123456789",
                "DON_XIN_PHEP",
                "don_khong_chu_ky.txt", "txt", 500,
                "KHONG_CO_CHU_KY_RSA" // Vi pham Hook cua StrictSecurityValidator
        );

        // Su dung StrictSecurityValidator bat Hook Method
        DocumentProcessor strictProcessor = new DocumentProcessor(new StrictSecurityValidator(), StorageAdapterFactory.getDefaultAdapter());
        strictProcessor.process(insecureDoc);

        System.out.println("=> Ket qua kiem duyet Hook: " + insecureDoc.getStatus().getDisplayName() + "\n");
    }

    // Kich ban 3: Strategy Pattern & Factory Method Pattern
    private static void runScenario3_StrategyAndFactory() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("3. KICH BAN 3: STRATEGY & FACTORY METHOD PATTERN (DOC DA DINH DANG)");
        System.out.println("--------------------------------------------------------------------------------");

        String[] testExtensions = {"txt", "pdf", "jpg"};
        for (String ext : testExtensions) {
            // Factory Method (Chuong 5) tao Strategy Extractor (Chuong 3)
            ContentExtractor extractor = ExtractorFactory.getExtractor(ext);
            try {
                File temp = createTempFile("sample." + ext, "Du lieu test cho dinh dang " + ext.toUpperCase());
                String extracted = extractor.extract(temp.getAbsolutePath());
                System.out.println("- [" + ext.toUpperCase() + "] " + extractor.getClass().getSimpleName() + " -> " + extracted);
            } catch (IOException e) {
                System.out.println("- Loi trich xuat ." + ext + ": " + e.getMessage());
            }
        }
        System.out.println();
    }

    // Kich ban 4: Adapter Pattern tich hop da nguon luu tru
    private static void runScenario4_AdapterStorage() throws Exception {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("4. KICH BAN 4: ADAPTER PATTERN (TICH HOP NGUON LUU TRU DA NEN TANG)");
        System.out.println("--------------------------------------------------------------------------------");

        Document doc = new Document(
                "DOC_STORAGE",
                "Le Van Cuong", "cuong.lv@gmail.com", "0987654321",
                "Can bo tiep nhan", "officer@tdtu.edu.vn", "0123456789",
                "BAO_CAO",
                "dummy.txt", "txt", 256, "RSA_OK"
        );

        // 1. Adapter Luu tru File JSON cuc bo
        DocumentStorageTarget jsonAdapter = new JsonFileStorageAdapter();
        jsonAdapter.save(doc);

        // 2. Adapter Luu tru MySQL Database (Mo phong)
        DocumentStorageTarget mySqlAdapter = new MySqlStorageAdapter();
        mySqlAdapter.save(doc);

        // 3. Adapter Luu tru AWS S3 Cloud Bucket (Mo phong)
        DocumentStorageTarget s3Adapter = new AwsS3StorageAdapter("bucket-edocument-2026");
        s3Adapter.save(doc);

        System.out.println("=> Adapter Pattern giup he thong tuong thich dong thoi 3 ha tang luu tru khac nhau ma khong can sua ma nguon DocumentProcessor!\n");
    }

    // Kich ban 5: Command Pattern voi Hoan tac (Undo/Redo) va Audit Logging
    private static void runScenario5_CommandPatternUndo() throws Exception {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("5. KICH BAN 5: COMMAND PATTERN (THUC THI, PHE DUYET, UNDO VA LOGGING)");
        System.out.println("--------------------------------------------------------------------------------");

        DocumentCommandInvoker invoker = new DocumentCommandInvoker();
        DocumentStorageTarget storage = new JsonFileStorageAdapter();
        DocumentProcessor processor = new DocumentProcessor(storage);

        File f = createTempFile("lenh_nop.txt", "Noi dung test Command Pattern");
        Document cmdDoc = new Document(
                "DOC_CMD_01",
                "Pham Hoang Dung", "dung.ph@gmail.com", "0933333333",
                "Can bo truc ban", "officer@tdtu.edu.vn", "0123456789",
                "HO_SO_THUE",
                f.getAbsolutePath(), "txt", 120, "RSA_OK"
        );

        // 1. Thuc thi Submit Command
        System.out.println("[Step 1] Nop ho so thong qua SubmitDocumentCommand:");
        invoker.executeCommand(new SubmitDocumentCommand(processor, cmdDoc));
        System.out.println("Trang thai hien tai: " + cmdDoc.getStatus().getDisplayName());

        // 2. Thuc thi Approve Command
        System.out.println("\n[Step 2] Can bo phe duyet qua ApproveDocumentCommand:");
        invoker.executeCommand(new ApproveDocumentCommand(storage, cmdDoc, "Duyet day du chung tu hop le"));
        System.out.println("Trang thai hien tai: " + cmdDoc.getStatus().getDisplayName());

        // 3. Hoan tac (Undo) lenh Phe duyet
        System.out.println("\n[Step 3] Can bo phat hien nham lan -> Goi Hoan tac (UNDO):");
        invoker.undo();
        System.out.println("Trang thai sau khi Undo: " + cmdDoc.getStatus().getDisplayName());

        // 4. In danh sach Audit Logging
        System.out.println("\n[Step 4] Danh sach nhat ky Audit Logging duoc luu lai boi Invoker:");
        for (String log : invoker.getAuditLogs()) {
            System.out.println("   * " + log);
        }
        System.out.println();
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
