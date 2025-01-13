import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class HtmlParser_3_3 {
    public static void main(String[] args) throws IOException {
        File file = new File("path_to_your_html_file.html");
        Document document = Jsoup.parse(file, "UTF-8");

        Elements hrefElements = document.select("[href]");
        Elements srcElements = document.select("[src]");

        for (Element element : hrefElements) {
            System.out.println("Href: " + element.attr("href"));
        }

        for (Element element : srcElements) {
            System.out.println("Src: " + element.attr("src"));
        }
    }
}