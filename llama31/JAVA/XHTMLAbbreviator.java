import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

public class XHTMLAbbreviator {
    public static String abbreviateXHTML(String xhtml, int wordLimit) {
        Document doc = Jsoup.parse(xhtml);
        abbreviateElement(doc.body(), wordLimit);
        return doc.body().html();
    }

    private static void abbreviateElement(Element element, int wordLimit) {
        int wordCount = 0;
        for (Node child : element.childNodes()) {
            if (child instanceof TextNode) {
                TextNode textNode = (TextNode) child;
                String text = textNode.text();
                String[] words = text.split("\\s+");
                for (String word : words) {
                    if (wordCount >= wordLimit) {
                        textNode.text(text.substring(0, text.indexOf(word)));
                        return;
                    }
                    wordCount++;
                }
            } else if (child instanceof Element) {
                Element childElement = (Element) child;
                abbreviateElement(childElement, wordLimit);
                if (wordCount >= wordLimit) {
                    childElement.remove();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String xhtml = "<html><body>This is a long text that needs to be abbreviated.</body></html>";
        int wordLimit = 5;
        String abbreviatedXHTML = abbreviateXHTML(xhtml, wordLimit);
        System.out.println(abbreviatedXHTML);
    }
}