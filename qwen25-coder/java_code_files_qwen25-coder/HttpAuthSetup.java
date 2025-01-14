import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class HttpAuthSetup {
    // Example of setting up Basic Auth in Java (note: not HTTP Digest)
    public static void main(String[] args) throws Exception {
        String url = "http://example.com"; // Define your URL here
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        String encoding = Base64.getEncoder().encodeToString(("username:password").getBytes(StandardCharsets.UTF_8));
        connection.setRequestProperty("Authorization", "Basic " + encoding);
    }
}