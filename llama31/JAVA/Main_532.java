import java.lang.String;
import java.net.URI;
import java.net.URISyntaxException;

public class Main_532 {
    public static void main(String[] args) throws URISyntaxException {
        String filePath = "/var/data/stuff/xyz.dat";
        String basePath = "/var/data";

        URI fileUri = new URI("file", "", filePath, "", "");
        URI baseUri = new URI("file", "", basePath, "", "");

        URI relativeUri = baseUri.relativize(fileUri);
        System.out.println(relativeUri.getPath()); // prints "stuff/xyz.dat"
    }
}