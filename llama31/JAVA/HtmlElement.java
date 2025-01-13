import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlElement {
    private Element element;

    public HtmlElement(Element element) {
        this.element = element;
    }

    public boolean usesClass(String cssClassname) {
        return element.hasClass(cssClassname);
    }

    public String getText() {
        return element.text();
    }

    public String getLink() {
        return element.select("a[href]").first().attr("href");
    }

    public static void main(String[] args) {
        // Example usage:
        String html = "<html><body><a href='https://www.example.com'>Example</a></body></html>";
        Document doc = Jsoup.parse(html);
        Element element = doc.select("a").first();
        HtmlElement htmlElement = new HtmlElement(element);
        System.out.println(htmlElement.getLink()); // prints https://www.example.com
    }
}