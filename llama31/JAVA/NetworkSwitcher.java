import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkSwitcher {
    private Context context;

    public NetworkSwitcher(Context context) {
        this.context = context;
    }

    public void switchNetwork() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (wifi.isConnected()) {
            // Disable WiFi
            cm.setNetworkPreference(ConnectivityManager.TYPE_MOBILE);
        } else if (mobile.isConnected()) {
            // Disable mobile network
            cm.setNetworkPreference(ConnectivityManager.TYPE_WIFI);
        }
    }

    public static void main(String[] args) {
        // This main method is not needed in an Android application.
        // The switchNetwork method should be called from an Activity or Service.
    }
}