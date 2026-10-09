package service;

import extractor.ContentExtractor;
import extractor.ExtractorFactory;
import model.Document;
import model.DocumentStatus;
import notification.NotificationManager;
import repository.DocumentRepository;
import repository.RepositoryFactory;
import validation.ValidationPipeline;
import validation.ValidationResult;

// Service dieu phoi quy trinh xu ly ho so
public class DocumentProcessor {
    private final ValidationPipeline validationPipeline;
    private final NotificationManager notificationManager;
    private final DocumentRepository repository;

    public DocumentProcessor() {
        this(ValidationPipeline.createDefaultPipeline(),
             NotificationManager.createDefaultManager(),
             RepositoryFactory.getDefaultRepository());
    }

    public DocumentProcessor(DocumentRepository repository) {
        this(ValidationPipeline.createDefaultPipeline(),
             NotificationManager.createDefaultManager(),
             repository);
    }

    public DocumentProcessor(ValidationPipeline pipeline, NotificationManager notifManager, DocumentRepository repository) {
        this.validationPipeline = (pipeline != null) ? pipeline : ValidationPipeline.createDefaultPipeline();
        this.notificationManager = (notifManager != null) ? notifManager : NotificationManager.createDefaultManager();
        this.repository = (repository != null) ? repository : RepositoryFactory.getDefaultRepository();
    }

    public void process(Document doc) {
        if (doc == null) return;

        System.out.println("\nBat dau xu ly ho so: " + doc.getId());

        // Buoc 1: Kiem tra ho so qua validation chain
        ValidationResult result = validationPipeline.validate(doc);
        if (!result.isValid()) {
            DocumentStatus oldStatus = doc.getStatus();
            doc.setStatus(DocumentStatus.TU_CHOI);
            System.out.println("Ho so bi tu choi: " + result.getErrorMessage());
            notificationManager.notifyStatusChanged(doc, oldStatus, DocumentStatus.TU_CHOI, result.getErrorMessage());
            return;
        }

        DocumentStatus s1 = doc.getStatus();
        doc.setStatus(DocumentStatus.DA_TIEP_NHAN);
        notificationManager.notifyStatusChanged(doc, s1, DocumentStatus.DA_TIEP_NHAN, "Ho so da tiep nhan");

        // Buoc 2: Trich xuat noi dung file
        try {
            ContentExtractor extractor = ExtractorFactory.getExtractor(doc.getFileExtension());
            String content = extractor.extract(doc.getFilePath());
            doc.setExtractedContent(content);
        } catch (Exception e) {
            DocumentStatus prev = doc.getStatus();
            doc.setStatus(DocumentStatus.TU_CHOI);
            System.out.println("Loi trich xuat: " + e.getMessage());
            notificationManager.notifyStatusChanged(doc, prev, DocumentStatus.TU_CHOI, e.getMessage());
            return;
        }

        // Buoc 3: Luu tru ho so
        try {
            repository.save(doc);
        } catch (Exception e) {
            DocumentStatus prev = doc.getStatus();
            doc.setStatus(DocumentStatus.TU_CHOI);
            System.out.println("Loi luu tru: " + e.getMessage());
            notificationManager.notifyStatusChanged(doc, prev, DocumentStatus.TU_CHOI, e.getMessage());
            return;
        }

        // Chuyen trang thai sang dang xet duyet
        DocumentStatus s2 = doc.getStatus();
        doc.setStatus(DocumentStatus.DANG_XET_DUYET);
        notificationManager.notifyStatusChanged(doc, s2, DocumentStatus.DANG_XET_DUYET, "Ho so dang xet duyet");

        // Hoan tat xu ly
        DocumentStatus s3 = doc.getStatus();
        doc.setStatus(DocumentStatus.DA_XU_LY);
        try { repository.save(doc); } catch (Exception ignored) {}
        notificationManager.notifyStatusChanged(doc, s3, DocumentStatus.DA_XU_LY, "Ho so da xu ly xong");

        System.out.println("Hoan tat xu ly: " + doc.getId() + " - Trang thai: " + doc.getStatus().getDisplayName());
    }

    public DocumentRepository getRepository() { return repository; }
    public NotificationManager getNotificationManager() { return notificationManager; }
    public ValidationPipeline getValidationPipeline() { return validationPipeline; }
}