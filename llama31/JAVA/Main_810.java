import java.net.URI;
import java.net.URISyntaxException;

public class Main_810 {
    public static boolean isValidUrl(String url) {
        try {
            URI uri = new URI(url);
            return uri.getScheme() != null && uri.getHost() != null;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidUrl("http://www.example.com"));  // prints: true
        System.out.println(isValidUrl("invalid url"));  // prints: false
    }
}