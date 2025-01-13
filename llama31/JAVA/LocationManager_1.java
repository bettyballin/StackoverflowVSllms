import java.lang.String;

public class LocationManager_1_1 {
    // Define the constants
    public static final String GPS_PROVIDER = "gps";
    public static final String NETWORK_PROVIDER = "network";
    // Note: WIFI_PROVIDER is not a standard provider in Android
    // It's not available in Cupcake (API 3) and was removed in later versions
    // You might want to use NETWORK_PROVIDER instead
    public static final String WIFI_PROVIDER = "wifi";

    private static final String[] LOCATION_PROVIDERS = new String[] {
        GPS_PROVIDER,
        NETWORK_PROVIDER,
        WIFI_PROVIDER
    };

    public static void main(String[] args) {
    }
}