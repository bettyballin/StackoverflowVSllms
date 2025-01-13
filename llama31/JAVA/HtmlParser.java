import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlParser {
    public static void main(String[] args) {
        String html = "<html><body><p>Hello <span id='1'>name</span> you are <span id='2'>age</span></p></body></html>";

        Document doc = Jsoup.parse(html);
        Element span1 = doc.getElementById("1");
        span1.text("John");

        Element span2 = doc.getElementById("2");
        span2.text("99");

        System.out.println(doc.html());
    }
}