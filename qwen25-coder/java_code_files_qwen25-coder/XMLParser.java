import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.StringReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;

public class XMLParser {
    public static void main(String[] args) {
        String xmlString = "<root><element>Hello, World!</element></root>";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML string
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            
            // You can now work with the document object 'doc'
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}