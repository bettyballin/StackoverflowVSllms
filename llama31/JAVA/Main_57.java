import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main_57 {
    public static void main(String[] args) {
        String htmlString = "<html>...</html>"; // replace with your HTML string
        Document doc = Jsoup.parse(htmlString);
        Element dataItem1 = doc.select("tr > td:nth-child(2)").first();
        String dataItem1Text = dataItem1.text().trim();
        System.out.println(dataItem1Text);
    }
}