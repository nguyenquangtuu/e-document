package notification;

import model.Document;
import model.DocumentStatus;

import java.util.*;

public class NotificationManager {

    private static volatile NotificationManager instance;

    private final List<DocumentObserver> observers = new ArrayList<>();
    private final Map<String, Set<String>> userPreferences = new HashMap<>();

    private NotificationManager() {

        attach(new EmailNotifier());
        attach(new SmsNotifier());
        attach(new AppPushNotifier());
    }

    public static NotificationManager getInstance() {
        if (instance == null) {
            synchronized (NotificationManager.class) {
                if (instance == null) {
                    instance = new NotificationManager();
                }
            }
        }
        return instance;
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

