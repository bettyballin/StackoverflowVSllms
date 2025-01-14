import java.lang.String;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.CellLocation;
import android.telephony.gsm.GsmCellLocation;

public class CellNetworkInfoRetriever {

    public CellNetworkInfoRetriever(Context context) {

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        String networkOperator = telephonyManager.getNetworkOperator();

        String mcc = networkOperator.substring(0, 3); // Mobile Country Code

        String mnc = networkOperator.substring(3); // Mobile Network Code

        CellLocation location = telephonyManager.getCellLocation();

        if (location instanceof GsmCellLocation) {

            GsmCellLocation gsmLocation = (GsmCellLocation) location;

            int cid = gsmLocation.getCid();   // Cell ID

            int lac = gsmLocation.getLac();   // Location Area Code

        }

    }

    public static void main(String[] args) {

    }

}