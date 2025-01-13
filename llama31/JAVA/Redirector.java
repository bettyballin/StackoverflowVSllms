import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class Redirector {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://example.com"); // replace with your URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(false); // assuming you want to handle redirects manually

        int responseCode = connection.getResponseCode();
        if (responseCode >= 300 && responseCode < 400) {
            String redirectUrl = connection.getHeaderField("Location");
            System.out.println("Redirecting to: " + redirectUrl);
        }
    }
}