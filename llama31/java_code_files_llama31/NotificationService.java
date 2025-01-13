/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class NotificationService {
    private ConcurrentHashMap<String, List<Notification>> cache = new ConcurrentHashMap();
    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getNotifications() {
        return this.notificationRepository.getNotifications();
    }

    public void cacheResults(List<Notification> list) {
        this.cache.put("notifications", list);
    }

    public void purgeNotifications() {
        this.notificationRepository.purgeNotifications();
    }

    public List<Notification> getCachedResults() {
        return this.cache.get("notifications");
    }
}
