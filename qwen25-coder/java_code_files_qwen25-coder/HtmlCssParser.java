import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlCssParser {
    public static boolean usesClass(String html, String cssClassName) {
        Document doc = Jsoup.parse(html);
        return !doc.select("." + cssClassName).isEmpty();
    }

    public static String getText(String html, String cssClassName) {
        Document doc = Jsoup.parse(html);
        Element element = doc.selectFirst("." + cssClassName);
        return element != null ? element.text() : null;
    }

    public static String getLink(String html, String cssClassName) {
        Document doc = Jsoup.parse(html);
        Element linkElement = doc.selectFirst("." + cssClassName + " a[href]");
        return linkElement != null ? linkElement.attr("href") : null;
    }

    public static void main(String[] args) {
    }
}