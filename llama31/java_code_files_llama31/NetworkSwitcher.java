/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 */
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkSwitcher {
    private Context context;

    public NetworkSwitcher(Context context) {
        this.context = context;
    }

    public void switchNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager)this.context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo.isConnected()) {
            connectivityManager.setNetworkPreference(0);
        } else if (networkInfo2.isConnected()) {
            connectivityManager.setNetworkPreference(1);
        }
    }

    public static void main(String[] stringArray) {
    }
}
