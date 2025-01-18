import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlTextExtractor {
    String mergedTextHtmlForm;
    Document doc = Jsoup.parse(mergedTextHtmlForm); //Parse HTML string into document
    String bodyText = doc.body().text(); //Get simple text from html content and replace new line char with <br /> tag
    public static void main(String[] args) {
    }
}