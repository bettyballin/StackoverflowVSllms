import java.lang.String;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main_127 {
    public static void main(String[] args) throws Exception {
        String html = "<html>\n" +
                      "   <head>\n" +
                      "       [snip]\n" +
                      "       <meta name=\"generator\" value=\"thevalue i'm looking for\" />\n" +
                      "       [snip]\n" +
                      "   </head>\n" +
                      "</html>";
        Document document = Jsoup.parse(html);
        Element metaElement = document.select("meta[name=generator]").first();
        String value = "";
        if (null != metaElement) {
            value = metaElement.attr("value");
        } else {
            // Handle error when element is not found
        }
    }
}