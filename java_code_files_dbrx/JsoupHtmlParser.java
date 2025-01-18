import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupHtmlParser {
    public static void main(String[] args) throws Exception {
        String url = "https://example.com";
        Document document = Jsoup.connect(url).get();
        Elements boldTextElements = document.select("b, strong"); // get elements with either 'b' or 'strong' tags
        for (Element boldText : boldTextElements) {
            System.out.println("Bold/Strong text: " +  boldText.text());
        }
    }
}