import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParser_6_6 {
    public static void main(String[] args) {
        HtmlParser_6 parser = new HtmlParser_6();
        parser.parseHtml();
    }

    public void parseHtml() {
        String html = "<html><head><meta charset='UTF-8'></head><body></body></html>";
        Document doc = Jsoup.parse(html);
        Elements metaTags = doc.getElementsByTag("meta");
        System.out.println(metaTags);
    }
}