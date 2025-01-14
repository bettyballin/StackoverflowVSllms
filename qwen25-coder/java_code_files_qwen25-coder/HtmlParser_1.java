import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class HtmlParser_1 {
    public static void main(String[] args) {
        try {
            // Load the HTML file into a Document object
            File input = new File("path/to/your/file.html");
            Document doc = Jsoup.parse(input, "UTF-8");

            // Select all elements with an href attribute
            Elements links = doc.select("[href]");
            for (Element link : links) {
                System.out.println("Href: " + link.attr("href"));
            }

            // Select all elements with a src attribute
            Elements media = doc.select("[src]");
            for (Element src : media) {
                System.out.println("Src: " + src.attr("src"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}