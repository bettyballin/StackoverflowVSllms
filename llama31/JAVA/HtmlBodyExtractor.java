import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlBodyExtractor {
    public static void main(String[] args) {
        String htmlDoc = "<html><head><title>Example</title></head><body><p>This is the body.</p></body></html>";
        Document doc = Jsoup.parse(htmlDoc);
        Element body = doc.body();

        if (body != null) {
            System.out.println(body.text());
        } else {
            System.out.println("No body found.");
        }
    }
}