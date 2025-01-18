import java.lang.String;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupExample {
    String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
    Document doc = Jsoup.parse(html);
    Element content = doc.select("b").first(); // using CSS Selector (like jQuery) to get first 'b' element, returns null if not found.
    
    public static void main(String[] args) {
    }
}