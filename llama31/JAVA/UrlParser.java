import java.net.URL;
import java.net.MalformedURLException;

public class UrlParser {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com#label"); // Replace with your URL
            String label = url.getRef(); // returns the fragment identifier (label)
            System.out.println(label);
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        }
    }
}