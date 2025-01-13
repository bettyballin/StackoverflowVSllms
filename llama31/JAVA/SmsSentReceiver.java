import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SmsSentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_SENT")) {
            // Handle the sent SMS here
        }
    }

    public static void main(String[] args) {
    }
}