import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main_556 {
    public static void main(String[] args) throws Exception {
        // Load the HTML document
        Document doc = Jsoup.connect("https://example.com").get();

        // Find all div elements with the specific CSS class
        Elements divs = doc.select("div.classname");

        // Iterate over the div elements and extract the data you need
        for (Element div : divs) {
            String text = div.text();
            String link = div.select("a[href]").first().attr("href");

            // Do something with the extracted data...
            System.out.println("Text: " + text);
            System.out.println("Link: " + link);
        }
    }
}