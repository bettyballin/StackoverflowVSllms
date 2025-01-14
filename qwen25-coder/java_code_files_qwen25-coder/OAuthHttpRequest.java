import java.net.HttpURLConnection;
import java.net.URL;

public class OAuthHttpRequest {
    // Example of setting an access token in a request header (OAuth Bearer Token) in Java
    String url = "http://example.com";
    String accessToken = "your_access_token";
    HttpURLConnection connection;

    {
        // Instance initializer block
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}