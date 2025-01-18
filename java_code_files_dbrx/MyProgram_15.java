import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.helper.W3CDom;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MyProgram {
    public static void main(String[] args) {
        try {
            // Parse the HTML document into a Jsoup Document object:
            Document doc = Jsoup.connect("http://example.com").get();
        
            // Convert the Jsoup Document to a W3C DOM document:
            org.w3c.dom.Document w3cDoc = new W3CDom().fromJsoup(doc);
        
            // Now you can use standard DOM and XPath APIs with "w3cDoc" object.
            // For example, print the root element name:
            System.out.println("Root element: " + w3cDoc.getDocumentElement().getNodeName());
        } catch (IOException | ParserConfigurationException ex) {
            // Handle exceptions here...
            ex.printStackTrace();
        }
    }
}