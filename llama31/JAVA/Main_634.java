import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.dom.W3CDocument;
import org.w3c.dom.Document;
import java.io.File;

public class Main_634 {
    public static void main(String[] args) throws Exception {
        // ...

        org.jsoup.nodes.Document jsoupDoc = Jsoup.parse(new File("example.html"), "UTF-8");
        org.w3c.dom.Document w3cDoc = new W3CDocument(jsoupDoc);
    }
}