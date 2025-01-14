public class SentSMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (getResultCode()) {
            case Activity.RESULT_OK:
                // SMS sent successfully
                break;
            case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                // Generic failure cause
                break;
            case SmsManager.RESULT_ERROR_NO_SERVICE:
                // Service is currently unavailable
                break;
            case SmsManager.RESULT_ERROR_NULL_PDU:
                // Null PDU
                break;
            case SmsManager.RESULT_ERROR_RADIO_OFF:
                // Radio was explicitly turned off
                break;
        }
    }

    public static void main(String[] args) {
    }
}

class BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        // Do nothing
    }

    public int getResultCode() {
        return 0;
    }
}

class Context {
}

class Intent {
}

class Activity {
    public static final int RESULT_OK = 0;
}

class SmsManager {
    public static final int RESULT_ERROR_GENERIC_FAILURE = 1;
    public static final int RESULT_ERROR_NO_SERVICE = 2;
    public static final int RESULT_ERROR_NULL_PDU = 3;
    public static final int RESULT_ERROR_RADIO_OFF = 4;
}