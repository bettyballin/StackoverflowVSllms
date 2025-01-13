import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeocodingExample {
    public static void main(String[] args) throws Exception {
        String address = "1600 Amphitheatre Parkway, Mountain View, CA";
        String apiKey = "YOUR_GOOGLE_MAPS_API_KEY";

        URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + apiKey);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse JSON response to extract longitude and latitude
            // ...
        } else {
            System.out.println("Failed to retrieve geocoding data");
        }
    }
}