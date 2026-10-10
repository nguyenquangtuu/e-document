package notification;

import model.Document;
import model.DocumentStatus;

import java.util.*;

/**
 * Singleton Pattern (Chuong 2 - Course Syllabus 504077):
 * Dam bao chi co duy nhat mot doi tuong NotificationManager ton tai trong toan bo chuong trinh
 * de quan ly tap trung viec phat thong bao (Subject trong Observer Pattern - Chuong 9).
 * 
 * Su dung co che Lazy Instantiation ket hop Double-Checked Locking dam bao Thread-Safe.
 */
public class NotificationManager {
    // Bien static volatile luu tru instance duy nhat
    private static volatile NotificationManager instance;

    private final List<DocumentObserver> observers = new ArrayList<>();
    private final Map<String, Set<String>> userPreferences = new HashMap<>();

    // Private Constructor ngan can viec khoi tao truc tiep tu ben ngoai
    private NotificationManager() {
        // Khoi tao mac dinh cac kenh thong bao
        attach(new EmailNotifier());
        attach(new SmsNotifier());
        attach(new AppPushNotifier());
    }

    // Phuong thuc toan cuc truy cap Singleton instance (Lazy Instantiation + Double-Checked Locking)
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

    // Observer Pattern: Dang ky Observer
    public void attach(DocumentObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    // Observer Pattern: Huy dang ky Observer
    public void detach(DocumentObserver observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    // Dang ky kenh thong bao ua thich cho nguoi dung (User Preferences)
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

    // Phat thong bao den tat ca Observer phu hop (Publish / Notify)
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
