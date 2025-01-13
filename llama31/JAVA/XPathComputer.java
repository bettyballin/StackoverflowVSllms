import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class XPathComputer {
    public static void main(String[] args) {
        String url = "https://stackoverflow.com";
        String knownValue = "faq";

        try {
            Document doc = Jsoup.connect(url).get();
            Element element = doc.getElementsByText(knownValue).first();

            if (element != null) {
                String xpath = getXPath(element);
                System.out.println(xpath);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static String getXPath(Element element) {
        StringBuilder xpath = new StringBuilder();
        Element current = element;

        while (current != null) {
            String name = current.tagName();
            int index = current.elementSiblingIndex() + 1;
            xpath.insert(0, "/" + name + "[" + index + "]");
            current = current.parent();
        }

        return xpath.toString();
    }
}