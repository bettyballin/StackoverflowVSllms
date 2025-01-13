import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlAttributeStripper {
    public static void main(String[] args) {
        String html = "<img src='image.jpg' alt='An image' width='100' height='100'>";

        Document doc = Jsoup.parse(html);
        Elements elements = doc.getAllElements();

        for (Element element : elements) {
            Attributes attributes = element.attributes();
            for (Attribute attribute : attributes) {
                if (!attribute.getKey().equals("src") && !attribute.getKey().equals("alt")) {
                    element.removeAttr(attribute.getKey());
                }
            }
        }

        System.out.println(doc.html());

        // Get the content from all "src" attributes
        Elements srcElements = doc.select("[src]");
        for (Element srcElement : srcElements) {
            System.out.println(srcElement.attr("src"));
        }
    }
}