import java.net.URL;
import java.net.HttpURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;

public class PostData {
    public static void post(String urlString, String data) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // Define the request method and headers.
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
        conn.setDoOutput(true); // Set the request to true for output data.

        try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
            byte[] input = data.getBytes();
            out.write(input, 0, input.length);
        } catch (IOException e) {
            throw new RuntimeException("Error sending POST request", e);
        }
    }

    public static void main(String[] args) {
    }
}