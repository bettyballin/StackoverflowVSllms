import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main_186 {
    public static void main(String args[]) throws Exception {
        Document document = Jsoup.connect("https://www.example.com").get();
        Element element = document.select("#attributeId").first();
        String attributeValue = element.attr("attributeName"); // Replace "attributeName" with the desired attribute name
        System.out.println(attributeValue);
    }
}