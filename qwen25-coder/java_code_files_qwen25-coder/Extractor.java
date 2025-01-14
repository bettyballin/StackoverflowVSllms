import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Extractor {
    public static void main(String[] args) {
        // Assuming you have the page source in the pageSource variable
        String pageSource = ""; // TODO: Provide the page source HTML as a string

        // Within your main method, after getting pageSource
        Document doc = Jsoup.parse(pageSource);
        String specificData = doc.select("#your-specific-element-selector").text();
        System.out.println("Extracted data: " + specificData);
    }
}