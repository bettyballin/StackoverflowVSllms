import java.net.URL;
import java.net.URLConnection;

public class WebServiceClient_1_1 {
    public static void main(String[] args) throws Exception {
        URLConnection connection = new URL("https://example.com/webservice").openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
    }
}