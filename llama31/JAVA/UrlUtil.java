import java.net.URI;
import java.net.URISyntaxException;

public class UrlUtil {
    public static String getDomain(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String host = uri.getHost();
        if (host.startsWith("www.")) {
            host = host.substring(4);
        }
        return host;
    }

    public static void main(String[] args) {
    }
}