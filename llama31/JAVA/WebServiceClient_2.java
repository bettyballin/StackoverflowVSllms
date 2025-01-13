import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceClient_2_2 {
    public static void main(String[] args) {
        try {
            String encodedCredentials = "your_encoded_credentials"; // replace with your actual encoded credentials
            URL url = new URL("https://example.com/webservice");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}