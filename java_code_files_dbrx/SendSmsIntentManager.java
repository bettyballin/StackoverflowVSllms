import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;

public class SendSmsIntentManager {

    private Context context;
    private SmsManager smsManager;
    private String recipientPhoneNumber;
    private String messageText;
    PendingIntent piSent;

    public SendSmsIntentManager(Context context, SmsManager smsManager, String recipientPhoneNumber, String messageText) {
        this.context = context;
        this.smsManager = smsManager;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.messageText = messageText;

        piSent = PendingIntent.getBroadcast(context, 0, new Intent("intent.SENT"), 0);
        smsManager.sendTextMessage(recipientPhoneNumber, null, messageText, piSent, null);
    }

    public static void main(String[] args) {
        // You can add code here to test the SendSmsIntentManager class
    }
}