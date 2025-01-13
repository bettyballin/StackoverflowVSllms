import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

public class ServiceMessengerHandler extends IntentService {

    // In your Service
    private Messenger mMessenger;

    public ServiceMessengerHandler() {
        super("ServiceMessengerHandler");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mMessenger = (Messenger) intent.getExtras().get("messenger");
        // Use the Messenger to send messages to the Activity
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
    }

    public static void main(String[] args) {
    }
}