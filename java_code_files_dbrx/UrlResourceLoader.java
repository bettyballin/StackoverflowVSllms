import java.net.URL;
import java.io.BufferedInputStream;
import java.io.IOException;

public class UrlResourceLoader {
    String file = "exampleFile"; // Define the file name
    URL url;
    BufferedInputStream x;

    public UrlResourceLoader() {
        url = this.getClass().getResource(file);
        System.out.println("url = " + url);
        try {
            x = new BufferedInputStream(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UrlResourceLoader();
    }
}