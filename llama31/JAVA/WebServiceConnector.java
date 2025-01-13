import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class WebServiceConnector {
    public static void main(String[] args) throws IOException {
        URLConnection connection = new URL("https://example.com/webservice").openConnection();
        String csrfToken = ""; // obtain CSRF token from web service
        connection.setRequestProperty("X-CSRF-Token", csrfToken);
    }
}