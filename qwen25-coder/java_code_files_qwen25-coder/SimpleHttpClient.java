import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHttpClient {

    public String sendGetRequest(String url) throws IOException {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder responseBuilder = new StringBuilder();

        try {
            URL requestUrl = new URL(url); // Create a URL object
            connection = (HttpURLConnection) requestUrl.openConnection(); // Open the URL connection
            connection.setRequestMethod("GET"); // Set the request method to GET

            int rc = connection.getResponseCode();
            if (rc != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code: " + rc);
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
                responseBuilder.append("\n");
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        return responseBuilder.toString();
    }

    public static void main(String[] args) {
        // Example usage:
        SimpleHttpClient client = new SimpleHttpClient();
        try {
            String response = client.sendGetRequest("http://www.example.com");
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}