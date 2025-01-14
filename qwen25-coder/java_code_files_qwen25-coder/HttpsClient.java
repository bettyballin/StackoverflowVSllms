import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.net.URL;

public class HttpsClient {

    public static void main(String[] args) throws Exception {
        try {
            // Create URL object
            URL url = new URL("https://example.com/api");
            
            // Open a connection using the URL
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            
            // Set request method to POST
            connection.setRequestMethod("POST");
            
            // Enable output stream for sending data
            connection.setDoOutput(true);
            
            // Set necessary headers
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            
            // Example JSON payload
            String jsonInputString = "{\"username\":\"user1\", \"password\":\"passw0rd\"}";
            
            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);           
            }
            
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            // Handle the response here
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}