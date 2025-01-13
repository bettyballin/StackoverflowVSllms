/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.telephony.SmsManager
 */
import android.telephony.SmsManager;

public class SMSSender {
    public static void main(String[] stringArray) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("phone_number", null, "message_text", null, null);
    }
}
