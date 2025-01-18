import java.lang.String;

public class DeviceBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            // Your Service
            context.startService(new Intent(context, YourBackgroundService.class));
        }
    }
    
    public static void main(String[] args) {
    }
}

class BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
    }
}

class Context {
    public void startService(Intent intent) {
    }
}

class Intent {
    public Intent(Context context, Class<?> cls) {
    }
    
    public String getAction() {
        return "";
    }
}

class YourBackgroundService {
}