import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main_95 {
    public static void main(String[] args) {
        String html = "<div class='test'><p>Content 1</p></div>" +
                      "<div class='otherclass'>Don't select me!</div>";
        Document document = Jsoup.parseBodyFragment(html); // parse a fragment of HTML, instead of full blown page (e.g., head and body)
        Elements divElements = document.select(".test");   // returns an empty element if there are no matches
        for (var divElement : divElements){
            System.out.println(divElement.toString());      // or .html() / .text() as needed to get the HTML/Text in string format
        }
    }
}