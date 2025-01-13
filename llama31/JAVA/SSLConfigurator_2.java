import java.net.HttpsURLConnection;
import java.net.URL;
import javax.net.ssl.SSLSocketFactory;
import java.util.HashMap;
import java.util.Map;

public class SSLConfigurator_2_2 {
    public static void main(String[] args) throws Exception {
        Map<String, URL> urlMap = new HashMap<>();
        urlMap.put("login", new URL("https://example.com")); // Replace with your URL

        HttpsURLConnection connection = (HttpsURLConnection) urlMap.get("login").openConnection();
        connection.setHostnameVerifier((hostname, session) -> {
            // Your custom hostname verification logic
            return true;
        });
        connection.setSSLSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault());
    }
}