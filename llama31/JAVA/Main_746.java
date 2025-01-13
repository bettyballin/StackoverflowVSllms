import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main_746 {
    public static void main(String[] args) throws Exception {
        // Connect to the website and get the HTML
        Document doc = Jsoup.connect("http://example.com").get();

        // Select the element with the id "important-data"
        Element element = doc.select("#important-data").first();

        // Check if the element exists to avoid NullPointerException
        if (element != null) {
            // Extract the text content
            String data = element.text();

            System.out.println(data);
        } else {
            System.out.println("Element with id 'important-data' not found.");
        }
    }
}