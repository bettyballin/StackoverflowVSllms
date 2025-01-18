import java.lang.String;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Main_303 {
    public static void main(String[] args) throws Exception {
        String html = "Your HTML code here";
        Document doc = Jsoup.parse(html);
        Elements links = doc.select("a[href]"); // selects all a elements with href attributes
        for (Element link : links) {
            System.out.println("\nHREF: " + link.attr("abs:href"));
        }
        Elements images = doc.select("img[src]"); // selects all img elements with src attributes
        for (Element image : images) {
            System.out.println("\nSRC: " + image.attr("abs:src"));
        }
    }
}