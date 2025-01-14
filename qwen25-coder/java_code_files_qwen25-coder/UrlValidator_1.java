import java.lang.String;
import java.net.URI;
import java.net.URISyntaxException;
public class UrlValidator_1 {
    public boolean isValidScheme(String url) {
        try {
            URI uri = new URI(url);
            return "http".equals(uri.getScheme()) || "https".equals(uri.getScheme());
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static void main(String[] args) {
    }
}