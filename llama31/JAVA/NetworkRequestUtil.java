import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;

public class NetworkRequestUtil {
    public static void main(String[] args) {
        // Create a new instance of NetworkRequestUtil
        NetworkRequestUtil util = new NetworkRequestUtil();
        // Call the requestNetwork method
        util.requestNetwork();
    }

    public void requestNetwork() {
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
        builder.addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR);

        NetworkRequest request = builder.build();
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        cm.requestNetwork(request, new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                // Use the cellular network
            }
        });
    }

    // Add this method to get the ConnectivityManager
    private ConnectivityManager getSystemService(String service) {
        // You need to get the context from somewhere, here we assume you have an activity
        // Replace this with your own context
        Context context = null;
        return (ConnectivityManager) context.getSystemService(service);
    }
}