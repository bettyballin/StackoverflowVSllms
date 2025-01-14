import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build;
import android.telephony.SmsMessage;
import android.telephony.SmsManager;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            // Retrieve the SMS message received
            Object[] pdusObj = (Object[]) bundle.get("pdus");
            String format = bundle.getString("format");
            if (pdusObj != null) {
                for (Object aPdusObj : pdusObj) {
                    SmsMessage currentMessage;
                    // Check Android version for createFromPdu method
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        currentMessage = SmsMessage.createFromPdu((byte[]) aPdusObj, format);
                    } else {
                        currentMessage = SmsMessage.createFromPdu((byte[]) aPdusObj);
                    }
                    String phoneNo = currentMessage.getDisplayOriginatingAddress();
                    String message = currentMessage.getDisplayMessageBody();

                    // Here you can insert the message into your database
                    new Thread(() -> sendToDatabase(phoneNo, message)).start();
                }
            }
        }
    }

    private void sendToDatabase(String phoneNo, String message) {
        // Implement HTTP POST request to send data to your server/database
        // Use libraries like Retrofit or Volley for network operations
    }
}

// Sending SMS using SmsManager
public class SMSSender {

    public static void sendSMS(Context context, String phoneNumber, String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
    }

    public static void main(String[] args) {
        // Main method implementation (if needed)
    }
}