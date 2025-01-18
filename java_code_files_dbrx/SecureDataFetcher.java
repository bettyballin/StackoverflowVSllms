import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.io.IOException;

public class SecureDataFetcher {
    static {
        try {
            String address = "https://myserver/myendpoint?securedata=encrypted";
            URL url = new URL(address);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            InputStream in = con.getInputStream();
            //handle response here...
        } catch (IOException e) {
            // handle and log exception here ...
        }
    }

    public static void main(String[] args) {
    }
}