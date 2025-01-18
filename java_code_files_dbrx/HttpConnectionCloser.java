import java.io.InputStream;
import java.io.IOException;
import javax.microedition.io.HttpConnection;
import javax.microedition.io.Connector;

public class HttpConnectionCloser {
    public static void main(String[] args) {
        HttpConnection hc = null;
        try {
            hc = (HttpConnection) Connector.open("http://example.com");
            InputStream is = hc.openInputStream(); /* consume or store inputstream data here */
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (hc != null) {
                try {
                    hc.close(); // Always close the connection when done with it!
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}