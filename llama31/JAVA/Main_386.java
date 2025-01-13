import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.model.CityResponse;

public class Main_386 {
    public static void main(String[] args) {
        WebServiceClient client = new WebServiceClient.Builder(42, "your_license_key").build();

        try {
            CityResponse response = client.city("192.0.2.1");

            String timezone = response.getLocation().getTimeZone();
            int offset = response.getLocation().getOffset();

            // Use the timezone and offset as needed
            System.out.println("Timezone: " + timezone);
            System.out.println("Offset: " + offset);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            client.close();
        }
    }
}