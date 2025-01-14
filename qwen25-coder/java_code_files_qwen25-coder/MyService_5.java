import java.lang.String;

// Stub classes to simulate Android classes and interfaces
class Service {
    public static final int START_NOT_STICKY = 2;

    public Object getSystemService(String name) { return null; }
    public <T> T getSystemService(Class<T> serviceClass) { return null; }
}

class Intent {}

interface IBinder {}

class Notification {}

class NotificationChannel {
    public NotificationChannel(String id, CharSequence name, int importance) {}
    public void setDescription(String description) {}
}

class NotificationManager {
    public static final String NOTIFICATION_SERVICE = "notification";
    public static final int IMPORTANCE_DEFAULT = 3;

    public void notify(int id, Notification notification) {}
    public void createNotificationChannel(NotificationChannel channel) {}
}

class Build {
    public static class VERSION {
        public static final int SDK_INT = 30; // Assume a version higher than O (26)
    }
    public static class VERSION_CODES {
        public static final int O = 26;
    }
}

class NotificationCompat {
    public static final int PRIORITY_DEFAULT = 0;

    public static class Builder {
        public Builder(Service service, String channelId) {}
        public Builder setSmallIcon(int icon) { return this; }
        public Builder setContentTitle(CharSequence title) { return this; }
        public Builder setContentText(CharSequence text) { return this; }
        public Builder setPriority(int priority) { return this; }
        public Notification build() { return new Notification(); }
    }
}

class R {
    public static class drawable {
        public static final int ic_notification = 1;
    }
}

class Context {
    public static final String NOTIFICATION_SERVICE = "notification";
}

// The main class
public class MyService_5 extends Service {

    private static final String CHANNEL_ID = "my_channel_id_01";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createNotificationChannel();
        
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("My Service")
            .setContentText("Running in the background.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());

        return START_NOT_STICKY;
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Channel";
            String description = "Description of My Channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void main(String[] args) {
        MyService_5 service = new MyService_5();
        service.onStartCommand(new Intent(), 0, 1);
    }
}