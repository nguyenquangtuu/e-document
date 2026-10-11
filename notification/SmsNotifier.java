package notification;

import model.Document;
import model.DocumentStatus;

public class SmsNotifier implements DocumentObserver {

    @Override
    public String getChannelName() {
        return "SMS";
    }

    @Override
    public void update(Document doc, DocumentStatus oldStatus, DocumentStatus newStatus, String message) {
        if (doc == null) return;
        System.out.println("SMS gui den " + doc.getApplicantPhone() + ": Ho so " + doc.getId() + " chuyen sang trang thai " + newStatus.getDisplayName());
    }
}

