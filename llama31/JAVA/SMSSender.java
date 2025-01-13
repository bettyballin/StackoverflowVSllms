import android.telephony.SmsManager;

public class SMSSender {
    public static void main(String[] args) {
        // Send an SMS message
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("phone_number", null, "message_text", null, null);
    }
}