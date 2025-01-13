import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParser_4_4 {
    public static void main(String[] args) {
        HtmlParser_4 parser = new HtmlParser_4();
        parser.parseHtml();
    }

    public void parseHtml() {
        String html = "<html><body><input name='username' type='text'></body></html>";
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("input[name='username']");
        System.out.println(elements);
    }
}