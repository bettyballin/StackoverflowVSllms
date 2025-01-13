/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.wifi.ScanResult
 *  android.net.wifi.WifiManager
 */
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.List;

public class WifiSignalStrength {
    public static void getSignalStrength(Context context) {
        WifiManager wifiManager = (WifiManager)context.getSystemService("wifi");
        List list = wifiManager.getScanResults();
        for (ScanResult scanResult : list) {
            int n = scanResult.level;
        }
    }

    public static void main(String[] stringArray) {
    }
}
