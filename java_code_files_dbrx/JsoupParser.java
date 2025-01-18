import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupParser {

    Document document;
    Element targetElement;
    String webServicesValue = null;

    public JsoupParser(String webResponse, String fieldName) {
        document = Jsoup.parse(webResponse);
        targetElement = document.getElementsByTag(fieldName).first();
        if (targetElement != null) {
            webServicesValue = targetElement.text();
        }
    }

    public static void main(String[] args) {
    }
}