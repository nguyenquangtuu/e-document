package notification;

import model.Document;
import model.DocumentStatus;

import java.util.*;

// Quan ly danh sach cac kenh thong bao (Subject trong Observer Pattern)
public class NotificationManager {
    private final List<DocumentObserver> observers = new ArrayList<>();
    private final Map<String, Set<String>> userPreferences = new HashMap<>();

    public NotificationManager() {}

    public static NotificationManager createDefaultManager() {
        NotificationManager manager = new NotificationManager();
        manager.attach(new EmailNotifier());
        manager.attach(new SmsNotifier());
        manager.attach(new AppPushNotifier());
        return manager;
    }

    public void attach(DocumentObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detach(DocumentObserver observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    // Dang ky kenh thong bao cho user
    public void setUserPreference(String userEmail, String... channels) {
        if (userEmail != null) {
            Set<String> set = new HashSet<>();
            if (channels != null) {
                for (String ch : channels) {
                    if (ch != null) set.add(ch.toUpperCase().trim());
                }
            }
            userPreferences.put(userEmail, set);
        }
    }

    // Gui thong bao den cac observer phu hop
    public void notifyStatusChanged(Document doc, DocumentStatus oldStatus, DocumentStatus newStatus, String message) {
        if (doc == null) return;
        String userEmail = doc.getApplicantEmail();
        Set<String> subscribedChannels = (userEmail != null) ? userPreferences.get(userEmail) : null;

        for (DocumentObserver observer : observers) {
            if (subscribedChannels == null || subscribedChannels.contains(observer.getChannelName().toUpperCase())) {
                observer.update(doc, oldStatus, newStatus, message);
            }
        }
    }

    public void notifyStatusChanged(Document doc, DocumentStatus oldStatus, DocumentStatus newStatus) {
        notifyStatusChanged(doc, oldStatus, newStatus, null);
    }

    public List<DocumentObserver> getObservers() {
        return Collections.unmodifiableList(observers);
    }
}
