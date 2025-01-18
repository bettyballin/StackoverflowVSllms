import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
    String html = "..."; // Your HTML content as a String.
    Document doc = Jsoup.parse(html);
    Element body = doc.body(); // Select the body element in your HTML document.
    Elements paragraphs = body.select("p"); // Choose all 'paragraph' elements, modify this selector based on tags and formatting you need to preserve (b tag or span etc.)
        
    public static void main(String[] args) {
    }
}