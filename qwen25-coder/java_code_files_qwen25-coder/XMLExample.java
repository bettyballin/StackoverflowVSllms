import java.lang.String;
// Example of handling XML in Java using DOMParser
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XMLExample {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("example.xml");
            // Process the document
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}