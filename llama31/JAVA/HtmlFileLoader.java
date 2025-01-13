import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;

public class HtmlFileLoader {
    public static void main(String[] args) {
        HtmlFileLoader loader = new HtmlFileLoader();
    }

    public HtmlFileLoader() {
        File file = new File("path/to/yourpage.html");
        try {
            URL url = file.toURI().toURL();
        } catch (MalformedURLException e) {
            System.out.println("Error creating URL: " + e.getMessage());
        }
    }
}