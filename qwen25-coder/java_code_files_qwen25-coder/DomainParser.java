import java.lang.String;
import java.net.MalformedURLException;
import java.net.URL;

public class DomainParser {
    public static String parseDomain(String urlString) {
        try {
            URL url = new URL(urlString);
            String host = url.getHost();
            // Remove 'www.' prefix if present
            return host.startsWith("www.") ? host.substring(4) : host;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL: " + urlString, e);
        }
    }

    public static void main(String[] args) {
        System.out.println(parseDomain("http://google.com/dhasjkdas/sadsdds/sdda/sdads.html")); // Output: google.com
        System.out.println(parseDomain("http://www.google.com/dhasjkdas/sadsdds/sdda/sdads.html")); // Output: google.com
        System.out.println(parseDomain("http://google.co.uk/dhasjkdas/sadsdds/sdda/sdads.html")); // Output: google.co.uk
    }
}