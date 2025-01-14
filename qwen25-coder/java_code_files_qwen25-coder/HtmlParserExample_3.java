import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlParserExample_3 {
    public static void main(String[] args) throws Exception {
        String html = "<meta content='blogger' name='generator'/>";
        Document doc = Jsoup.parse(html);
        
        String generatorContent = doc.select("meta[name=generator]").attr("content");
        System.out.println("Generator: " + generatorContent);
    }
}