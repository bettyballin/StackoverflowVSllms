/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 */
import android.app.Activity;
import android.content.Intent;

public class Broadcaster
extends Activity {
    public void broadcastIntent() {
        Intent intent = new Intent("com.example.MY_INTENT");
        this.sendBroadcast(intent);
    }

    public static void main(String[] stringArray) {
    }
}
