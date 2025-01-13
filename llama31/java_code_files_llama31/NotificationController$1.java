/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

static class NotificationController.1
implements NotificationRepository {
    NotificationController.1() {
    }

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
}
