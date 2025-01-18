import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Main_23 {
    public static void main(String[] args) throws IOException {
        String url = "https://example.com"; // Your target URL here
        Document document = Jsoup.connect(url).get();
        Elements spanWithImportantData = document.select("#important-data");

        for (org.jsoup.nodes.Element element : spanWithImportantData) {
            System.out.println("Tag: " + element.tag());
            System.out.println("Text: " + element.text());
        }
    }
}