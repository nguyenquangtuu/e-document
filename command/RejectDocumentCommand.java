package command;

import model.Document;
import model.DocumentStatus;
import notification.NotificationManager;
import storage.DocumentStorageTarget;

/**
 * Concrete Command 3: Lenh tu choi ho so (Reject Document).
 */
public class RejectDocumentCommand implements DocumentCommand {
    private final DocumentStorageTarget storage;
    private final Document document;
    private final String rejectionReason;
    private DocumentStatus previousStatus;

    public RejectDocumentCommand(DocumentStorageTarget storage, Document document, String rejectionReason) {
        this.storage = storage;
        this.document = document;
        this.rejectionReason = rejectionReason;
        this.previousStatus = (document != null) ? document.getStatus() : null;
    }

    @Override
    public void execute() throws Exception {
        if (document == null) return;
        this.previousStatus = document.getStatus();
        document.setStatus(DocumentStatus.TU_CHOI);
        if (storage != null) {
            storage.save(document);
        }
        String msg = "Ho so bi TU CHOI: " + (rejectionReason != null ? rejectionReason : "Khong dat yeu cau.");
        NotificationManager.getInstance().notifyStatusChanged(document, previousStatus, DocumentStatus.TU_CHOI, msg);
        System.out.println("[Command::Reject] Tu choi ho so: " + document.getId() + " - Ly do: " + rejectionReason);
    }

    @Override
    public void undo() throws Exception {
        if (document == null) return;
        DocumentStatus current = document.getStatus();
        document.setStatus(previousStatus);
        if (storage != null) {
            storage.save(document);
        }
        NotificationManager.getInstance().notifyStatusChanged(
            document, current, previousStatus, 
            "Hoan tac (Undo) lenh tu choi. Quay ve trang thai: " + (previousStatus != null ? previousStatus.getDisplayName() : "")
        );
        System.out.println("[Command::Reject] Da hoan tac lenh tu choi ho so: " + document.getId());
    }

    @Override
    public String getDescription() {
        return "Tu choi ho so: " + (document != null ? document.getId() : "");
    }

    @Override
    public Document getDocument() {
        return document;
    }
}
