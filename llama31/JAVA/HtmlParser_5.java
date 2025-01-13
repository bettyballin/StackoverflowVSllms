import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser_5_5 {
    public static void main(String[] args) {
        String html = "<html><body><p>Hello, <b>world!</b> <span style='color: red'>This is red.</span></p></body></html>";
        Document doc = Jsoup.parse(html);

        Elements elements = doc.getAllElements();
        for (Element element : elements) {
            if (element.tagName().equals("b")) {
                System.out.println("Bold text: " + element.text());
            } else if (element.tagName().equals("span")) {
                System.out.println("Styled text: " + element.text());
                System.out.println("Style: " + element.attr("style"));
            }
        }
    }
}