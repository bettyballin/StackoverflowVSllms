import java.lang.String;
import java.lang.Integer;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.CellLocation;
import android.telephony.gsm.GsmCellLocation;

public class NetworkInfoRetriever {

    private void showGPRSInfo(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        // MCC / MNC
        String networkOperator = telephonyManager.getNetworkOperator();
        int mcc = Integer.parseInt(networkOperator.substring(0, 3));
        int mnc = Integer.parseInt(networkOperator.substring(3));

        // LAC
        int lac = ((GsmCellLocation) telephonyManager.getCellLocation()).getLac();
    }

    public static void main(String[] args) {
        // Instantiate NetworkInfoRetriever and call showGPRSInfo with a valid Context
    }
}