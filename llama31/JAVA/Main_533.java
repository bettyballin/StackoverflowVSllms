import java.net.URI;
import java.net.URISyntaxException;

public class Main_533 {
    public static void main(String[] args) throws URISyntaxException {
        String relativeUriString = "stuff/xyz.dat"; // Example URI path
        URI relativeUri = new URI(null, null, relativeUriString, null);
        
        String relativePath = "./" + relativeUri.getPath();
        System.out.println(relativePath); // prints "./stuff/xyz.dat"
    }
}