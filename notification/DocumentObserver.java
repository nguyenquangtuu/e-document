package notification;

import model.Document;
import model.DocumentStatus;

public interface DocumentObserver {
    void update(Document doc, DocumentStatus oldStatus, DocumentStatus newStatus, String message);
    String getChannelName();
}

