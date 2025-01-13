import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class Main_649 {
    public static void main(String[] args) throws Exception {
        DOMParser parser = new DOMParser();
        parser.parse("example.html");
        Document document = parser.getDocument();
    }
}