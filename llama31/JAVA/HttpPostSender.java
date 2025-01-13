import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;

public class HttpPostSender {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com"); // replace with your URL
            byte[] data = "Hello, World!".getBytes(); // replace with your data

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Send data to the server
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(data);
            outputStream.close();

            System.out.println("Data sent successfully");
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error sending data: " + e.getMessage());
        }
    }
}