import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class LinkScraper {
    public static void main(String[] args) throws IOException {
        String url = "https://example.com";
        Document document = Jsoup.connect(url).get();
        Elements linkElements = document.select("a[href]"); // get elements with anchor (a) and href attributes
        for (Element link : linkElements) {
            System.out.println("URL: " + link.attr("abs:href")); // outputs the absolute URL of each link
        }
    }
}