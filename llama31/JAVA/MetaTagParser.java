import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MetaTagParser {
    public static void main(String[] args) {
        String html = "<html><head><meta name='description' content='This is a test page'><meta name='keywords' content='test,page'></head><body>This is the body</body></html>";
        Document doc = Jsoup.parse(html);
        Elements metaTags = doc.select("head meta");
        for (Element metaTag : metaTags) {
            System.out.println("Name: " + metaTag.attr("name"));
            System.out.println("Content: " + metaTag.attr("content"));
        }
    }
}