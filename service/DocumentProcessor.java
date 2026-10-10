package service;

import extractor.ContentExtractor;
import extractor.ExtractorFactory;
import model.Document;
import model.DocumentStatus;
import notification.NotificationManager;
import storage.DocumentStorageTarget;
import storage.StorageAdapterFactory;
import validation.AbstractDocumentValidator;
import validation.StandardDocumentValidator;
import validation.ValidationResult;

/**
 * Service dieu phoi quy trinh xu ly ho so:
 * - Kiem duyet bang Template Method Pattern (AbstractDocumentValidator)
 * - Trich xuat noi dung bang Strategy & Factory Method Pattern (ContentExtractor, ExtractorFactory)
 * - Luu tru bang Adapter Pattern (DocumentStorageTarget)
 * - Phat thong bao bang Singleton & Observer Pattern (NotificationManager)
 */
public class DocumentProcessor {
    private final AbstractDocumentValidator validator;
    private final NotificationManager notificationManager;
    private final DocumentStorageTarget storageAdapter;

    public DocumentProcessor() {
        this(new StandardDocumentValidator(),
             NotificationManager.getInstance(),
             StorageAdapterFactory.getDefaultAdapter());
    }

    public DocumentProcessor(DocumentStorageTarget storageAdapter) {
        this(new StandardDocumentValidator(),
             NotificationManager.getInstance(),
             storageAdapter);
    }

    public DocumentProcessor(AbstractDocumentValidator validator, DocumentStorageTarget storageAdapter) {
        this(validator, NotificationManager.getInstance(), storageAdapter);
    }

    public DocumentProcessor(AbstractDocumentValidator validator, NotificationManager notifManager, DocumentStorageTarget storageAdapter) {
        this.validator = (validator != null) ? validator : new StandardDocumentValidator();
        this.notificationManager = (notifManager != null) ? notifManager : NotificationManager.getInstance();
        this.storageAdapter = (storageAdapter != null) ? storageAdapter : StorageAdapterFactory.getDefaultAdapter();
    }

    public boolean process(Document doc) {
        if (doc == null) return false;

        System.out.println("\n[DocumentProcessor] Bat dau xu ly ho so: " + doc.getId());

        // Buoc 1: Kiem tra ho so qua Template Method Pattern
        ValidationResult result = validator.validate(doc);
        if (!result.isValid()) {
            DocumentStatus oldStatus = doc.getStatus();
            doc.setStatus(DocumentStatus.TU_CHOI);
            System.out.println("[DocumentProcessor] Tu choi ho so tai buoc '" + result.getFailedStepName() + "': " + result.getErrorMessage());
            notificationManager.notifyStatusChanged(doc, oldStatus, DocumentStatus.TU_CHOI, result.getErrorMessage());
            return false;
        }

        DocumentStatus s1 = doc.getStatus();
        doc.setStatus(DocumentStatus.DA_TIEP_NHAN);
        notificationManager.notifyStatusChanged(doc, s1, DocumentStatus.DA_TIEP_NHAN, "Ho so hop le va da duoc tiep nhan.");

        // Buoc 2: Trich xuat noi dung file qua Strategy & Factory Method
        try {
            ContentExtractor extractor = ExtractorFactory.getExtractor(doc.getFileExtension());
            String content = extractor.extract(doc.getFilePath());
            doc.setExtractedContent(content);
            System.out.println("[DocumentProcessor] Trich xuat thanh cong voi " + extractor.getClass().getSimpleName());
        } catch (Exception e) {
            DocumentStatus prev = doc.getStatus();
            doc.setStatus(DocumentStatus.TU_CHOI);
            System.out.println("[DocumentProcessor] Loi trich xuat: " + e.getMessage());
            notificationManager.notifyStatusChanged(doc, prev, DocumentStatus.TU_CHOI, "Loi trich xuat: " + e.getMessage());
            return false;
        }

        // Buoc 3: Luu tru ho so thong qua Adapter Pattern
        try {
            storageAdapter.save(doc);
            System.out.println("[DocumentProcessor] Luu tru thanh cong qua adapter: " + storageAdapter.getStorageName());
        } catch (Exception e) {
            DocumentStatus prev = doc.getStatus();
            doc.setStatus(DocumentStatus.TU_CHOI);
            System.out.println("[DocumentProcessor] Loi luu tru: " + e.getMessage());
            notificationManager.notifyStatusChanged(doc, prev, DocumentStatus.TU_CHOI, "Loi luu tru: " + e.getMessage());
            return false;
        }

        // Chuyen trang thai sang DANG_XET_DUYET
        DocumentStatus s2 = doc.getStatus();
        doc.setStatus(DocumentStatus.DANG_XET_DUYET);
        notificationManager.notifyStatusChanged(doc, s2, DocumentStatus.DANG_XET_DUYET, "Ho so dang duoc can bo tham dinh.");

        // Hoan tat xu ly sang DA_XU_LY
        DocumentStatus s3 = doc.getStatus();
        doc.setStatus(DocumentStatus.DA_XU_LY);
        try {
            storageAdapter.save(doc);
        } catch (Exception ignored) {}
        notificationManager.notifyStatusChanged(doc, s3, DocumentStatus.DA_XU_LY, "Ho so da duoc xu ly hoan tat.");

        System.out.println("[DocumentProcessor] Hoan tat quy trinh ho so " + doc.getId() + " - Trang thai: " + doc.getStatus().getDisplayName());
        return true;
    }

    public DocumentStorageTarget getStorageAdapter() { return storageAdapter; }
    public NotificationManager getNotificationManager() { return notificationManager; }
    public AbstractDocumentValidator getValidator() { return validator; }
}