import java.lang.String;
import java.net.URI;
import java.net.URL;

public class UriUrlExample {
    public static void main(String[] args) {
        try {
            // Creating a URL (which is also a URI)
            URL url = new URL("http://www.example.com/document.txt");
            System.out.println("URL: " + url.toString());

            // Creating a URI
            URI uri = new URI("https://www.example.com/resource/path?query=123#fragment");
            System.out.println("URI from URL: " + uri.toString());

            // Example of URN (this is just a string representation, not a fully resolvable URN)
            String urn = "urn:uuid:6e8bc430-9c3a-11d9-bb48-0000fdeffba5";
            System.out.println("Example of URN: " + urn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}