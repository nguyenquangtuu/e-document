package command;

import model.Document;
import model.DocumentStatus;
import notification.NotificationManager;
import storage.DocumentStorageTarget;

public class ApproveDocumentCommand implements DocumentCommand {
    private final DocumentStorageTarget storage;
    private final Document document;
    private final String officerNote;
    private DocumentStatus previousStatus;

    public ApproveDocumentCommand(DocumentStorageTarget storage, Document document, String officerNote) {
        this.storage = storage;
        this.document = document;
        this.officerNote = officerNote;
        this.previousStatus = (document != null) ? document.getStatus() : null;
    }

    @Override
    public void execute() throws Exception {
        if (document == null) return;
        this.previousStatus = document.getStatus();
        document.setStatus(DocumentStatus.DA_XU_LY);
        if (storage != null) {
            storage.save(document);
        }
        String msg = "Ho so da duoc CAN BO PHE DUYET: " + (officerNote != null ? officerNote : "Hop le");
        NotificationManager.getInstance().notifyStatusChanged(document, previousStatus, DocumentStatus.DA_XU_LY, msg);
        System.out.println("[Command::Approve] Phe duyet ho so: " + document.getId() + " thanh cong.");
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
            "Hoan tac (Undo) lenh phe duyet. Quay ve trang thai: " + (previousStatus != null ? previousStatus.getDisplayName() : "")
        );
        System.out.println("[Command::Approve] Da hoan tac phe duyet ho so: " + document.getId());
    }

    @Override
    public String getDescription() {
        return "Phe duyet ho so: " + (document != null ? document.getId() : "");
    }

    @Override
    public Document getDocument() {
        return document;
    }
}

