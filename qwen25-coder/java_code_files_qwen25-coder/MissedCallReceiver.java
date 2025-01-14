import java.lang.String;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class MissedCallReceiver extends BroadcastReceiver {
    private boolean wasRinging = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
        if (stateStr.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            wasRinging = true;
        }
        else if (stateStr.equals(TelephonyManager.EXTRA_STATE_IDLE)){
            if (wasRinging){
                String numberMissed = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                
                // TODO: Implement sending email or other actions here
                System.out.println("Missed call from: " + numberMissed);

                wasRinging = false;
            }
        }
    }

	public static void main(String[] args) {
	}
}