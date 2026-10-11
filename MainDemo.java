import command.ApproveDocumentCommand;
import command.DocumentCommandInvoker;
import command.SubmitDocumentCommand;
import extractor.ContentExtractor;
import extractor.ExtractorFactory;
import model.Document;
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

public class MainDemo {

    public static void main(String[] args) {
        System.out.println("He thong Quan ly Ho so Dien tu (eDocument v2.0)");
        System.out.println("Khoi chay cac kich ban kiem thu:\n");

        File sampleFile = createTempFile("don_xin_phep.txt", "Kinh gui Ban Giam hieu, em xin nghi hoc vi ly do suc khoe.");

        try {
            runScenario1(sampleFile);
            runScenario2();
            runScenario3();
            runScenario4();
            runScenario5();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nHoan tat kiem tra!");
    }

    private static void runScenario1(File file) {
        System.out.println("\n[Kich ban 1] Xu ly ho so hop le:");

        NotificationManager notif = NotificationManager.getInstance();
        notif.setUserPreference("an.nv@gmail.com", "EMAIL", "SMS");

        Document doc = new Document(
                "DOC01",
                "Nguyen Van An", "an.nv@gmail.com", "0901234567",
                "Can bo truc ban", "officer@tdtu.edu.vn", "0123456789",
                "DON_XIN_PHEP",
                file.getAbsolutePath(), "txt", 1024,
                "RSA_VALID_SIGNATURE_01"
        );

        DocumentProcessor processor = new DocumentProcessor(new StandardDocumentValidator(), StorageAdapterFactory.getDefaultAdapter());
        processor.process(doc);

        System.out.println("=> Ket qua: " + doc.getStatus().getDisplayName());
    }

    private static void runScenario2() {
        System.out.println("\n[Kich ban 2] Kiem duyet an ninh (chua co chu ky so RSA hop le):");

        Document insecureDoc = new Document(
                "DOC02",
                "Tran Thi Bich", "bich.tt@gmail.com", "0912345678",
                "Can bo truc ban", "officer@tdtu.edu.vn", "0123456789",
                "DON_XIN_PHEP",
                "don_khong_chu_ky.txt", "txt", 500,
                "KHONG_CO_CHU_KY_RSA"
        );

        DocumentProcessor strictProcessor = new DocumentProcessor(new StrictSecurityValidator(), StorageAdapterFactory.getDefaultAdapter());
        strictProcessor.process(insecureDoc);

        System.out.println("=> Ket qua: " + insecureDoc.getStatus().getDisplayName());
    }

    private static void runScenario3() {
        System.out.println("\n[Kich ban 3] Trich xuat noi dung theo dinh dang tep:");

        String[] testExtensions = {"txt", "pdf", "jpg"};
        for (String ext : testExtensions) {
            ContentExtractor extractor = ExtractorFactory.getExtractor(ext);
            try {
                File temp = createTempFile("sample." + ext, "Du lieu test cho dinh dang " + ext.toUpperCase());
                String extracted = extractor.extract(temp.getAbsolutePath());
                System.out.println(" - [" + ext.toUpperCase() + "] " + extractor.getClass().getSimpleName() + " -> " + extracted);
            } catch (IOException e) {
                System.out.println(" - Loi doc file ." + ext + ": " + e.getMessage());
            }
        }
    }

    private static void runScenario4() throws Exception {
        System.out.println("\n[Kich ban 4] Thu nghiem cac phuong thuc luu tru:");

        Document doc = new Document(
                "DOC_STORAGE",
                "Le Van Cuong", "cuong.lv@gmail.com", "0987654321",
                "Can bo tiep nhan", "officer@tdtu.edu.vn", "0123456789",
                "BAO_CAO",
                "dummy.txt", "txt", 256, "RSA_OK"
        );

        DocumentStorageTarget jsonAdapter = new JsonFileStorageAdapter();
        jsonAdapter.save(doc);

        DocumentStorageTarget mySqlAdapter = new MySqlStorageAdapter();
        mySqlAdapter.save(doc);

        DocumentStorageTarget s3Adapter = new AwsS3StorageAdapter("bucket-edocument-2026");
        s3Adapter.save(doc);
    }

    private static void runScenario5() throws Exception {
        System.out.println("\n[Kich ban 5] Thao tac ho so, phe duyet va hoan tac (Undo):");

        DocumentCommandInvoker invoker = new DocumentCommandInvoker();
        DocumentStorageTarget storage = new JsonFileStorageAdapter();
        DocumentProcessor processor = new DocumentProcessor(storage);

        File f = createTempFile("lenh_nop.txt", "Noi dung nop ho so thue");
        Document cmdDoc = new Document(
                "DOC_CMD_01",
                "Pham Hoang Dung", "dung.ph@gmail.com", "0933333333",
                "Can bo truc ban", "officer@tdtu.edu.vn", "0123456789",
                "HO_SO_THUE",
                f.getAbsolutePath(), "txt", 120, "RSA_OK"
        );

        System.out.println("1. Nop ho so:");
        invoker.executeCommand(new SubmitDocumentCommand(processor, cmdDoc));
        System.out.println("Trang thai hien tai: " + cmdDoc.getStatus().getDisplayName());

        System.out.println("\n2. Can bo phe duyet:");
        invoker.executeCommand(new ApproveDocumentCommand(storage, cmdDoc, "Duyet day du chung tu hop le"));
        System.out.println("Trang thai hien tai: " + cmdDoc.getStatus().getDisplayName());

        System.out.println("\n3. Hoan tac phe duyet (Undo):");
        invoker.undo();
        System.out.println("Trang thai sau khi Undo: " + cmdDoc.getStatus().getDisplayName());

        System.out.println("\n4. Nhat ky thao tac:");
        for (String log : invoker.getAuditLogs()) {
            System.out.println("   * " + log);
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
