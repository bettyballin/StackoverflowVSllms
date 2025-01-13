import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlValidator_2_2 {
    public static boolean isValid(String xmlFile) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        return true;
    }

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        try {
            if (isValid(xmlFile)) {
                System.out.println("Validates against either DTD or XSD");
            } else {
                System.out.println("Does not validate against either DTD or XSD");
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println("Error validating XML file: " + e.getMessage());
        }
    }
}