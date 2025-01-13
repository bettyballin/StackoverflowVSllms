import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupExample {
    public static void main(String[] args) {
        // Load the XHTML string into a Jsoup Document
        String xhtmlString = "<html><div class='classname' id='testId'></div></html>";
        try {
            Document doc = Jsoup.parse(xhtmlString, "UTF-8");

            // Use CSS selectors to select elements
            Elements elements = doc.select("div.classname");

            // Loop through the selected elements
            for (Element element : elements) {
                // Do something with the element
                System.out.println(element.attr("id"));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}