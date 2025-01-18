public class NetworkRequestManager {

    public static void main(String[] args) {
        new NetworkRequestManager().manageNetworkRequest();
    }

    public void manageNetworkRequest() {
        Context context = new Context();
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            boolean isWifiAvailable = false; // replace with an actual check for Wi-Fi availability.
            if (isWifiAvailable) { 
                builder.addTransportType(NetworkCapabilities.TRANSPORT_WIFI);
            } else {  // use cellular network instead of Wi-Fi
                builder.addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR);
            }
            cm.requestNetwork(builder.build(), new ConnectivityManager.NetworkCallback() {
                @Override
                public void onAvailable(Network network) {
                    // Connect your application to this particular available network here.
                }
            });
        }
    }
}

// Dummy classes to make the code compile
class Context {
    public static final String CONNECTIVITY_SERVICE = "connectivity";

    public Object getSystemService(String name) {
        if (CONNECTIVITY_SERVICE.equals(name)) {
            return new ConnectivityManager();
        } else {
            return null;
        }
    }
}

class ConnectivityManager {

    public void requestNetwork(NetworkRequest request, NetworkCallback callback) {
        // Simulate network request
    }

    public static class NetworkCallback {
        public void onAvailable(Network network) {
            // Handle network availability
        }
    }
}

class NetworkRequest {

    public static class Builder {
        public Builder addTransportType(int transportType) {
            // Add transport type
            return this;
        }

        public NetworkRequest build() {
            return new NetworkRequest();
        }
    }
}

class NetworkCapabilities {
    public static final int TRANSPORT_WIFI = 1;
    public static final int TRANSPORT_CELLULAR = 2;
}

class Network {
    // Represents a network
}