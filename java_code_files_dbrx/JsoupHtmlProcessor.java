import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupHtmlProcessor {
    String html = "<html>...</html>"; // Your initial HTML

    public JsoupHtmlProcessor() {
        Document document = Jsoup.parse(html);
        // Find elements by id and set innerHTML for each element:
        Element e1 = document.getElementById("1");
        e1.text("John");

        Element e2 = document.getElementById("2");
        e2.text("99");
    }

    public static void main(String[] args) {
        new JsoupHtmlProcessor();
    }
}