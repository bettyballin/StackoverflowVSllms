import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class SecureURLConnection {
    public static void main(String[] args) throws Exception {
        // Use HTTPS (TLS) for secure communication
        URL url = new URL("https://example.com");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
    }
}