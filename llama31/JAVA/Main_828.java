import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main_828 {
    public static void main(String[] args) {
        // Connect to the URL and parse the HTML
        try {
            Document doc = Jsoup.connect("https://www.example.com").get();

            // Select all links on the page
            Elements links = doc.select("a");

            // Iterate over the links and print their URLs
            for (Element link : links) {
                System.out.println(link.attr("href"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}