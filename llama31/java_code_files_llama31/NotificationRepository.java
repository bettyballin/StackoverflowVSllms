/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

interface NotificationRepository {
    public List<Notification> getNotifications();

    public void purgeNotifications();
}
