// Example usage of Jsoup
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebScraper_2 {
    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://example.com").get();
            String title = document.title();
            System.out.println(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}