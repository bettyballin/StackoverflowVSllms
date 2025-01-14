import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlParser {
    public static void main(String[] args) {
        String htmlSource = "<html><head></head><body>" +
                            "<div class=\"special-class\">This is the text you want to extract.</div>" +
                            "</body></html>";
        
        Document document = Jsoup.parse(htmlSource);
        Element div = document.selectFirst("div.special-class");
        
        if (div != null) {
            System.out.println("Div content: " + div.text());
        } else {
            System.out.println("Div not found.");
        }
    }
}