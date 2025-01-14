import java.lang.String;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

public class SslCheck {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            
            // Attempt to connect
            connection.connect();

            System.out.println("SSL is enabled on the server.");
        } catch (Exception e) {
            System.out.println("Failed to establish an SSL/TLS connection. SSL may not be enabled or there's another issue: " + e.getMessage());
        }
    }
}