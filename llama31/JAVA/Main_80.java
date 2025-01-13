import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main_80 {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("http://www.example.com").get();
        String title = doc.title();
        System.out.println(title);
    }
}