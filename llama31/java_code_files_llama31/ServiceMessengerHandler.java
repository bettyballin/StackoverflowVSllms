/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Intent
 *  android.os.Messenger
 */
import android.app.IntentService;
import android.content.Intent;
import android.os.Messenger;

public class ServiceMessengerHandler
extends IntentService {
    private Messenger mMessenger;

    public ServiceMessengerHandler() {
        super("ServiceMessengerHandler");
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        this.mMessenger = (Messenger)intent.getExtras().get("messenger");
        return super.onStartCommand(intent, n, n2);
    }

    protected void onHandleIntent(Intent intent) {
    }

    public static void main(String[] stringArray) {
    }
}
