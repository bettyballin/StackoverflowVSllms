import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleMapsDirections {
  public static void main(String[] args) throws Exception {
    String apiKey = "YOUR_API_KEY";
    String origin = "City+A";
    String destination = "City+B";

    URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?" +
        "origin=" + origin +
        "&destination=" + destination +
        "&mode=driving" +
        "&key=" + apiKey);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    int responseCode = connection.getResponseCode();
    if (responseCode == 200) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String response = reader.readLine();
      // Parse the JSON response to extract the route coordinates
      System.out.println(response);
    } else {
      System.out.println("Error: " + responseCode);
    }
  }
}