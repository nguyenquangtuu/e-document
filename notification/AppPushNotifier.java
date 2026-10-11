package notification;

import model.Document;
import model.DocumentStatus;

public class AppPushNotifier implements DocumentObserver {

    @Override
    public String getChannelName() {
        return "APP_PUSH";
    }

    @Override
    public void update(Document doc, DocumentStatus oldStatus, DocumentStatus newStatus, String message) {
        if (doc == null) return;
        System.out.println("App Push gui den nguoi dung " + doc.getApplicantName() + ": Ho so " + doc.getId() + " - " + newStatus.getDisplayName());
    }
}

