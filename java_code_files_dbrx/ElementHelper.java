import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ElementHelper {

    public boolean usesClass(String cssClassName, Element element) {
        return element.hasClass(cssClassName);
    }

    public String getText(Element element) {
        return element.text(); // extract text from the selected div
    }

    public String[] getLinks(Element element) {
        ArrayList<String> links = new ArrayList<>();
        Elements elementsWithLinks = element.select("a[href]"); // select all a tags with attribute href, which are usually links.
        for (Element link : elementsWithLinks) {
            links.add(link.absUrl("href")); // add only absolute URLs to the list
        }
        return links.toArray(new String[0]); // convert ArrayList to an array
    }

    public static void main(String[] args) {
    }
}