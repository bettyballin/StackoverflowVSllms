import java.util.List;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

public class WifiSignalStrength {
    public static void getSignalStrength(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> scanResults = wifiManager.getScanResults();

        for (ScanResult result : scanResults) {
            int signalStrength = result.level;
            // Do something with the signal strength value
        }
    }

	public static void main(String[] args) {
	}
}