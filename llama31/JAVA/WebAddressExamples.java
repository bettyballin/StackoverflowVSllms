import java.net.URI;
import java.net.URL;

public class WebAddressExamples {
    public static void main(String[] args) throws Exception {
        // URI example in Java
        URI uri = new URI("mailto:user@example.com");
        System.out.println("URI: " + uri);

        // URL example in Java
        URL url = new URL("https://www.example.com/path/to/resource");
        System.out.println("URL: " + url);

        // URN example in Java
        String urn = "urn:isbn:0-486-27557-4";
        System.out.println("URN: " + urn);
    }
}