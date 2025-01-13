import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;

public class MyService_8_8 extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        // ...
        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("My Notification")
                .setContentText("This is a notification from my service")
                .setSmallIcon(R.drawable.my_icon)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static void main(String[] args) {
    }
}