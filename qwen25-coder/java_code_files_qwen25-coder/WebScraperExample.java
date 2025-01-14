import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebScraperExample {
    public static void main(String[] args) {
        String html = "<div>\n" +
                      "  <div>\n" +
                      "    <span id=\"important-data\">information here</span>\n" +
                      "  </div>\n" +
                      "</div>";

        // Parse the HTML content
        Document document = Jsoup.parse(html);

        // Select the element by its ID and extract the text
        Element importantDataElement = document.getElementById("important-data");
        String importantData = importantDataElement.text();

        // Print the extracted data
        System.out.println(importantData);  // Output: information here
    }
}