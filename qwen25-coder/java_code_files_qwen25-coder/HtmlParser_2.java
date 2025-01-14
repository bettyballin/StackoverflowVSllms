import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser_2 {
    public static void main(String[] args) {
        // Example HTML content
        String htmlContent = "<html><body>"
                + "<div class=\"classname\">Example Text <a href=\"http://example.com\">Link</a></div>"
                + "</body></html>";

        // Parse the HTML content
        Document doc = Jsoup.parse(htmlContent);

        // Select elements by CSS class
        Elements divs = doc.select(".classname");

        for (Element div : divs) {
            System.out.println("Text: " + div.text());
            Element link = div.selectFirst("a[href]");
            if (link != null) {
                System.out.println("Link: " + link.attr("href"));
            }
        }
    }

    public static boolean usesClass(String html, String cssClassName) {
        Document doc = Jsoup.parse(html);
        return !doc.select("." + cssClassName).isEmpty();
    }
}