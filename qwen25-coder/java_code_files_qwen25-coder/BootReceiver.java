package com.example.yourserviceapp;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent serviceIntent = new Intent(context, YourService.class);
            context.startService(serviceIntent);
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
    public static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";

    public Intent(Context context, Class<?> cls) {
    }

    public String getAction() {
        return "";
    }
}

class YourService {
}