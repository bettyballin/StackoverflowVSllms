import java.lang.String;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main_14 {
    public static void main(String[] args) {
        String html = "<p>This is a <strong>paragraph</strong> containing some <em> HTML </em>.<p>";
        Document doc = Jsoup.parse(html);
        String plainText = doc.body().text(); // "This is a paragraph containing some HTML."
    }
}