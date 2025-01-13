import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class YourService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(1, new Notification.Builder(this)
                .setContentTitle("Your Service")
                .setContentText("Running in foreground")
                .build());
        // do your work here
        return super.onStartCommand(intent, flags, startId);
    }

    public static void main(String[] args) {
    }
}