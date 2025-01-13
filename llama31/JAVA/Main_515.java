import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;

public class Main_515 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com"); // Replace with the desired URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000); // 5 seconds
            connection.setReadTimeout(30000); // 30 seconds
            
            // Just to ensure we're doing something with the connection
            // This can be removed or modified based on your needs
            System.out.println("Response Code: " + connection.getResponseCode());
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Failed to establish connection: " + e.getMessage());
        }
    }
}