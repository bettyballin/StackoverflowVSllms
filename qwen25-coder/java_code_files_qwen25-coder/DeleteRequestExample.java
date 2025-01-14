import java.net.URL;
import java.net.HttpURLConnection;

public class DeleteRequestExample {
    // Example of making a DELETE request without a body using Java's HttpURLConnection
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://example.com/resource/to/delete");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}