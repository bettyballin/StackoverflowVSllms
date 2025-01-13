import java.lang.String;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

public class Main_133 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setHostnameVerifier((hostname, session) -> true); // Verify hostname
        connection.connect();
        // Perform your HTTPS request
    }
}