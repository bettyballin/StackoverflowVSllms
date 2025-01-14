import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {

    public static void main(String[] args) {
        String url = "http://example.com"; // Replace with target URL
        try {
            Document document = Jsoup.connect(url).get();

            List<String> links = new ArrayList<>();
            List<String> linkTexts = new ArrayList<>();

            Elements elements = document.select("a[href]");
            for (Element element : elements) {
                String href = element.attr("href");
                String text = element.text();

                links.add(href);
                linkTexts.add(text);
            }

            System.out.println("Links: " + links);
            System.out.println("Link Texts: " + linkTexts);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}