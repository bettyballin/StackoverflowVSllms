import java.lang.String;

public class NetworkSwitcher {
    private Context context;

    public NetworkSwitcher(Context context) {
        this.context = context;
    }

    public void requestWifi() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addTransportType(NetworkCapabilities.TRANSPORT_WIFI);

            connectivityManager.requestNetwork(builder.build(), new ConnectivityManager.NetworkCallback() {
                // Handle the network callback
            });
        }
    }

    public void requestCellular() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR);

            connectivityManager.requestNetwork(builder.build(), new ConnectivityManager.NetworkCallback() {
                // Handle the network callback
            });
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        NetworkSwitcher switcher = new NetworkSwitcher(context);
        switcher.requestWifi();
        switcher.requestCellular();
    }
}

class Context {
    public static final String CONNECTIVITY_SERVICE = "connectivity";

    public Object getSystemService(String name) {
        return new ConnectivityManager();
    }
}

class ConnectivityManager {
    public void requestNetwork(NetworkRequest request, NetworkCallback callback) {
        // Simulated network request
    }

    public static class NetworkCallback {
        // Simulated network callback
    }
}

class Build {
    public static class VERSION {
        public static final int SDK_INT = 21;
    }

    public static class VERSION_CODES {
        public static final int LOLLIPOP = 21;
    }
}

class NetworkRequest {
    public static class Builder {
        public void addTransportType(int transportType) {
            // Simulated adding transport type
        }

        public NetworkRequest build() {
            return new NetworkRequest();
        }
    }
}

class NetworkCapabilities {
    public static final int TRANSPORT_WIFI = 1;
    public static final int TRANSPORT_CELLULAR = 0;
}