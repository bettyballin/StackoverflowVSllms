import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils; // Added missing import
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

public class DistanceCalculator {

    public static void main(String[] args) throws IOException {
        String place1 = "New York, NY";
        String place2 = "Los Angeles, CA";

        double[] coordinatesPlace1 = getCoordinates(place1);
        double[] coordinatesPlace2 = getCoordinates(place2);

        if (coordinatesPlace1 != null && coordinatesPlace2 != null) {
            double distance = calculateDistance(coordinatesPlace1[0], coordinatesPlace1[1],
                    coordinatesPlace2[0], coordinatesPlace2[1]);
            System.out.println("Distance between " + place1 + " and " + place2 + ": " + distance + " km");
        }
    }

    private static double[] getCoordinates(String place) throws IOException { // Corrected parameter name
        String apiKey = "YOUR_API_KEY"; // Please replace 'YOUR_API_KEY' with your actual Google Maps API key
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address="
                + place.replaceAll("\\s+", "+") + "&key=" + apiKey;
        HttpGet request = new HttpGet(url);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String content = EntityUtils.toString(response.getEntity());
                JSONObject json = new JSONObject(content);
                if (json.has("results") && json.getJSONArray("results").length() > 0) {
                    double lat = json.getJSONArray("results")
                            .getJSONObject(0)
                            .getJSONObject("geometry")
                            .getJSONObject("location")
                            .getDouble("lat");

                    double lng = json.getJSONArray("results")
                            .getJSONObject(0)
                            .getJSONObject("geometry")
                            .getJSONObject("location")
                            .getDouble("lng");
                    return new double[]{lat, lng};
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        return null;
    }

    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in kilometers
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}