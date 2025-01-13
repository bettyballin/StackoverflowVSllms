import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;

public class Main_633 {
    public static void main(String[] args) {
        try {
            Document document = Jsoup.parse(new File("example.html"), "UTF-8");
            System.out.println(document);
        } catch (IOException e) {
            System.err.println("Error parsing HTML file: " + e.getMessage());
        }
    }
}