import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;

public class Main_165 {
    public static String getClosestServerIp(String countryCode) {
        // implement logic to get closest server IP based on country code
        // for demonstration purposes, return a static IP
        return "192.168.1.100";
    }

    public static void main(String[] args) {
        try {
            // Initialize the GeoIP database
            DatabaseReader reader = new DatabaseReader.Builder("GeoLite2-City.mmdb").build();

            // Get the user's IP address (assuming this is a web application, for demonstration purposes use a static IP)
            String userIp = "8.8.8.8";

            // Get the user's location from the GeoIP database
            CityResponse response = reader.city(userIp);

            // Determine the closest server based on the user's location
            String closestServerIp = getClosestServerIp(response.getCountry().getIsoCode());

            // Print the IP address of the closest server
            System.out.println(closestServerIp);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the DatabaseReader to prevent resource leaks
            if (reader != null) {
                reader.close();
            }
        }
    }
}