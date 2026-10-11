package notification;

import model.Document;
import model.DocumentStatus;

public class EmailNotifier implements DocumentObserver {

    @Override
    public String getChannelName() {
        return "EMAIL";
    }

    @Override
    public void update(Document doc, DocumentStatus oldStatus, DocumentStatus newStatus, String message) {
        if (doc == null) return;
        System.out.println("Email gui den " + doc.getApplicantEmail() + ": Ho so " + doc.getId() + " chuyen sang trang thai " + newStatus.getDisplayName());
    }
}

