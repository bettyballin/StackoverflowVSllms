import javax.microedition.io.HttpConnection;
import javax.microedition.io.Connector;
import java.io.IOException;

public class Main_53 {
    public static void main(String[] args) throws IOException {
        String url = "http://example.com/webservice";
        HttpConnection conn = (HttpConnection) Connector.open(url);
        // Send request and receive response...
        // For example:
        int statusCode = conn.getResponseCode();
        if (statusCode != HttpConnection.HTTP_OK) {
            System.out.println("Request failed with status code: " + statusCode);
        } else {
            System.out.println("Request successful");
        }
        conn.close();
    }
}