import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

// Define the Notification class
class Notification {
    private String message;

    public Notification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// Define the NotificationRepository interface
interface NotificationRepository {
    List<Notification> getNotifications();
    void purgeNotifications();
}

// Define the NotificationService class
class NotificationService {
    private ConcurrentHashMap<String, List<Notification>> cache = new ConcurrentHashMap<>();
    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getNotifications() {
        return notificationRepository.getNotifications();
    }

    public void cacheResults(List<Notification> notifications) {
        cache.put("notifications", notifications);
    }

    public void purgeNotifications() {
        notificationRepository.purgeNotifications();
    }

    public List<Notification> getCachedResults() {
        return cache.get("notifications");
    }
}

// Define the NotificationController class
public class NotificationController {
    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public List<Notification> getNotifications() {
        try {
            List<Notification> notifications = notificationService.getNotifications();
            notificationService.cacheResults(notifications);
            notificationService.purgeNotifications();
            return notificationService.getCachedResults();
        } catch (Exception e) {
            return notificationService.getCachedResults();
        }
    }

    public static void main(String[] args) {
        // Create a mock NotificationRepository
        NotificationRepository notificationRepository = new NotificationRepository() {
            @Override
            public List<Notification> getNotifications() {
                List<Notification> notifications = new ArrayList<>();
                notifications.add(new Notification("Notification 1"));
                notifications.add(new Notification("Notification 2"));
                return notifications;
            }

            @Override
            public void purgeNotifications() {
                System.out.println("Purging notifications...");
            }
        };

        // Create a NotificationService and a NotificationController
        NotificationService notificationService = new NotificationService(notificationRepository);
        NotificationController notificationController = new NotificationController(notificationService);

        // Get notifications
        List<Notification> notifications = notificationController.getNotifications();

        // Print notifications
        for (Notification notification : notifications) {
            System.out.println(notification.getMessage());
        }
    }
}