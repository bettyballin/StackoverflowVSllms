/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SmsSentReceiver
extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_SENT")) {
            // empty if block
        }
    }

    public static void main(String[] stringArray) {
    }
}
