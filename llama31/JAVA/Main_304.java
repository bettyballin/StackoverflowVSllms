import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main_304 {
    public static void main(String[] args) {
        try {
            // Load the webpage
            Document doc = Jsoup.connect("http://example.com").get();

            // Extract all links
            Elements links = doc.select("a");

            // Get the URLs and text of the links
            for (Element link : links) {
                String url = link.attr("href");
                String text = link.text();
                System.out.println("URL: " + url + ", Text: " + text);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}