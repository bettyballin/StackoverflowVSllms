import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlAttributeStripper {
    public static String stripAttributesExceptSrcAndAlt(String html) {
        Document doc = Jsoup.parse(html);
        Elements elements = doc.getAllElements();
        
        for (Element element : elements) {
            // Save src and alt attributes if they exist
            String src = element.attr("src");
            String alt = element.attr("alt");

            // Remove all attributes
            element.attributes().remove();

            // Restore saved attributes
            if (!src.isEmpty()) {
                element.attr("src", src);
            }
            if (!alt.isEmpty()) {
                element.attr("alt", alt);
            }
        }

        return doc.outerHtml();
    }

    public static void main(String[] args) {
        String html = "<img src='image.jpg' alt='Image description' other='value'/>";
        System.out.println(stripAttributesExceptSrcAndAlt(html));
    }
}