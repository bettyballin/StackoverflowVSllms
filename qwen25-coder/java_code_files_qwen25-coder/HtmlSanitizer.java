import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;

public class HtmlSanitizer {
    public static void main(String[] args) {
        String htmlInput = "<a href=\"blah.asp?fn=view&g_varID=1234\">some text</a>";

        // Parse and clean the HTML, escaping '&' in query parameters
        Document doc = Jsoup.parse(htmlInput);
        doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
        String sanitizedHtml = doc.html();

        System.out.println(sanitizedHtml);
    }
}