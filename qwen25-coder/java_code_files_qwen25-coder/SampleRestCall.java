import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SampleRestCall {
    public void makeGetRequest() {
        String urlString = "http://localhost:8080/api/data"; // Replace with your actual URL

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int statusCode = connection.getResponseCode();

            if (statusCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the input stream
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                StringBuilder responseContent = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();

                // Process the response from the server
                String result = responseContent.toString();
                // Further processing...
            } else {
                // Handle the error case
                System.out.println("GET request failed with status code: " + statusCode);
            }
        } catch (IOException e) {
            // Handle the error appropriately
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SampleRestCall sample = new SampleRestCall();
        sample.makeGetRequest();
    }
}