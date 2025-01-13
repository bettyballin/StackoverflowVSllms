import java.net.URI;
import java.net.URISyntaxException;

public class Main_539 {
    public static void main(String[] args) {
        String userInputUrl = "http://example.com"; // replace with your URL
        try {
            URI uri = new URI(userInputUrl);
            if (uri.getScheme().equals("http") || uri.getScheme().equals("https")) {
                System.out.println("URL is valid");
            } else {
                System.out.println("URL is invalid");
            }
        } catch (URISyntaxException e) {
            System.out.println("Invalid URL syntax");
        }
    }
}