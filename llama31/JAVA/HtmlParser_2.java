import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlParser_2_2 {
    public static void main(String[] args) {
        String htmlSource = "<html><body><div class='myClass'>Hello World!</div></body></html>";
        Document doc = Jsoup.parse(htmlSource);
        Element div = doc.selectFirst("div.myClass");
        String content = div.text();
        System.out.println(content); // prints "Hello World!"
    }
}