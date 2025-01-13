/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class NotificationController {
    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public List<Notification> getNotifications() {
        try {
            List<Notification> list = this.notificationService.getNotifications();
            this.notificationService.cacheResults(list);
            this.notificationService.purgeNotifications();
            return this.notificationService.getCachedResults();
        }
        catch (Exception exception) {
            return this.notificationService.getCachedResults();
        }
    }

    public static void main(String[] stringArray) {
        NotificationRepository notificationRepository = new NotificationRepository(){

            @Override
            public List<Notification> getNotifications() {
                ArrayList<Notification> arrayList = new ArrayList<Notification>();
                arrayList.add(new Notification("Notification 1"));
                arrayList.add(new Notification("Notification 2"));
                return arrayList;
            }

            @Override
            public void purgeNotifications() {
                System.out.println("Purging notifications...");
            }
        };
        NotificationService notificationService = new NotificationService(notificationRepository);
        NotificationController notificationController = new NotificationController(notificationService);
        List<Notification> list = notificationController.getNotifications();
        for (Notification notification : list) {
            System.out.println(notification.getMessage());
        }
    }
}
