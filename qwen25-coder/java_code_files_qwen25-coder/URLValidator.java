import java.lang.String;
import java.net.URI;
import java.net.URISyntaxException;

public class URLValidator {
    public static void main(String[] args) {
        String url = "http://example.com/path/to/file[3].html";
        try {
            URI uri = new URI(url);
            if (uri.getHost() != null && uri.getHost().contains("[")) {
                // Handle IPv6 address
                System.out.println("Valid IPv6 URL");
            } else if (url.matches(".+\\[.+\\].+")) {
                // Handle URLs with square brackets not part of an IPv6 address
                throw new IllegalArgumentException("URL contains illegal square brackets: " + url);
            } else {
                System.out.println("Valid URL");
            }
        } catch (URISyntaxException e) {
            System.err.println("Invalid URL syntax: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}