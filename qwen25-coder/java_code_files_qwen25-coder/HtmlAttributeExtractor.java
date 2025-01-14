import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlAttributeExtractor extends HtmlAttributeStripper {
    public static List<String> extractSrcAttributes(String html) {
        Document doc = Jsoup.parse(html);
        Elements elements = doc.getAllElements();

        List<String> srcList = new ArrayList<>();
        for (Element element : elements) {
            String src = element.attr("src");
            if (!src.isEmpty()) {
                srcList.add(src);
            }
        }

        return srcList;
    }

    public static void main(String[] args) {
        String html = "<img src='image1.jpg'/><a src='link.html'><img src='image2.png' alt='Alt text'/></a>";
        List<String> srcAttributes = extractSrcAttributes(html);
        for (String src : srcAttributes) {
            System.out.println(src);
        }
    }
}

class HtmlAttributeStripper {
    // Parent class implementation (if any)
}