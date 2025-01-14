import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlParserWithJsoup {
    public static void main(String[] args) {
        try {
            // Fetch the document from the URL
            Document doc = Jsoup.connect("http://example.com").get();
            
            // Select the meta tag by name and get its value attribute
            String value = doc.select("meta[name=generator]").attr("value");
            
            if (!value.isEmpty()) {
                System.out.println("The value is: " + value);
            } else {
                System.out.println("Value not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}