import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CxfRestClientExample {
    public static void main(String[] args) {
        String baseUrl = "https://api.example.com";
        String resourcePath = "/resource";
        String fullUrl = baseUrl + resourcePath;

        try {
            // Create a URL object with the full URL
            URL url = new URL(fullUrl);

            // Open an HTTP connection to the URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            conn.setRequestMethod("GET");

            // Set the Accept header to indicate the response format
            conn.setRequestProperty("Accept", "application/json");

            // Check if the response code is HTTP 200 OK
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + conn.getResponseCode());
            }

            // Read the response from the input stream
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            StringBuilder response = new StringBuilder();

            while ((output = responseBuffer.readLine()) != null) {
                response.append(output);
            }

            // Close the connection
            conn.disconnect();

            // Print the response
            System.out.println(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}