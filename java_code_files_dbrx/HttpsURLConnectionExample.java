import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class HttpsURLConnectionExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com"); // Example HTTPS URL
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            try {
                System.out.println("Response Code: " + con.getResponseCode());
                // You may also want to check for possible exceptions when reading the InputStream or using BufferedReader, e.g., IOException
            } finally {
                con.disconnect(); // Close the connection regardless of what happened
            }
        } catch (IOException ex) {
            // Handle error
        }
    }
}