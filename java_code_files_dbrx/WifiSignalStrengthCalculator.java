import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiInfo;

public class WifiSignalStrengthCalculator {
    private int getNetworkSignalStrength(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null && wifiManager.isWifiEnabled()) {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int linkSpeed = wifiInfo.getLinkSpeed(); // in Mbps
            return (int)(wifiInfo.getRssi() - 10 * Math.max(Math.log((double)linkSpeed)/Math.log(10), 1));
        } else {
            return Integer.MIN_VALUE;
        }
    }
    public static void main(String[] args) {
    }
}