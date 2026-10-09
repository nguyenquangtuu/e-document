package notification;

import model.Document;
import model.DocumentStatus;

// Observer Pattern: interface nhan thong bao khi trang thai ho so thay doi
public interface DocumentObserver {
    void update(Document doc, DocumentStatus oldStatus, DocumentStatus newStatus, String message);
    String getChannelName();
}
