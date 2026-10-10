package command;

import model.Document;
import model.DocumentStatus;
import notification.NotificationManager;
import service.DocumentProcessor;

/**
 * Concrete Command 1: Lenh nop va xu ly ho so (Submit Document).
 */
public class SubmitDocumentCommand implements DocumentCommand {
    private final DocumentProcessor processor;
    private final Document document;
    private DocumentStatus previousStatus;
    private boolean executedSuccessfully = false;

    public SubmitDocumentCommand(DocumentProcessor processor, Document document) {
        this.processor = processor;
        this.document = document;
        this.previousStatus = (document != null) ? document.getStatus() : null;
    }

    @Override
    public void execute() throws Exception {
        if (document == null) return;
        this.previousStatus = document.getStatus();
        System.out.println("[Command::Submit] Thuc thi lenh nop ho so: " + document.getId());
        this.executedSuccessfully = processor.process(document);
    }

    @Override
    public void undo() throws Exception {
        if (document == null || !executedSuccessfully) return;
        DocumentStatus current = document.getStatus();
        document.setStatus(previousStatus != null ? previousStatus : DocumentStatus.MOI_TAO);
        
        // Luu lai trang thai sau hoan tac
        processor.getStorageAdapter().save(document);
        
        NotificationManager.getInstance().notifyStatusChanged(
            document, current, document.getStatus(), 
            "Lenh nop ho so da duoc HOAN TAC (Undo). Trang thai quay ve: " + document.getStatus().getDisplayName()
        );
        System.out.println("[Command::Submit] Da hoan tac (Undo) lenh nop ho so: " + document.getId());
    }

    @Override
    public String getDescription() {
        return "Nop ho so: " + (document != null ? document.getId() + " (" + document.getApplicantName() + ")" : "null");
    }

    @Override
    public Document getDocument() {
        return document;
    }
}
