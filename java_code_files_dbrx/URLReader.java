import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.net.URLConnection;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://example.com"); // Define the URL
        URLConnection conn = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName(conn.getContentEncoding() != null ? conn.getContentEncoding() : "UTF-8")));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            // process each line
        }
        in.close();
    }
}