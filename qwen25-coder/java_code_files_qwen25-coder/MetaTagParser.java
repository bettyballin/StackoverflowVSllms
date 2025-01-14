import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MetaTagParser {
    public static void main(String[] args) {
        String html = "<html><head>"
                    + "<meta name='description' content='example description'>"
                    + "<meta name='keywords' content='java, jsoup, parsing'>"
                    + "</head><body>Some body text</body></html>";

        Document doc = Jsoup.parse(html);
        Elements metaTags = doc.select("meta");

        for (Element tag : metaTags) {
            String name = tag.attr("name");
            String content = tag.attr("content");
            System.out.println("Meta Tag - Name: " + name + ", Content: " + content);
        }
    }
}