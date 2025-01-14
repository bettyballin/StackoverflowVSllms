import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.net.ssl.HttpsURLConnection;

public class WebServiceConsumer {
    public static void main(String[] args) throws Exception {
        String httpsURL = "https://example.com/api/data";
        
        // Create a connection to the URL
        HttpsURLConnection connection = (HttpsURLConnection) new java.net.URL(httpsURL).openConnection();
        connection.setRequestMethod("GET");

        // If you need to add headers:
        connection.setRequestProperty("Authorization", "Bearer your_token_here");
        
        // Get the input stream and read data
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Print the result
            System.out.println(content.toString());
        } else {
            System.out.println("GET request not worked");
        }

        connection.disconnect();
    }
}