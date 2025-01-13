import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlValidator_6 {
    public static void main(String[] args) {
        // Load XSD schema
        String xsdFile = "path/to/your/xsd/file.xsd";
        DOMParser parser = new DOMParser();
        parser.setFeature("http://xml.org/sax/features/validation", true);
        parser.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", xsdFile);

        // Load XML file
        String xmlFile = "path/to/your/xml/file.xml";
        try {
            Document doc = parser.parse(new InputSource(xmlFile));

            // Validate XML against XSD
            parser.parse(new InputSource(xmlFile));
            System.out.println("XML file is valid.");
        } catch (SAXException e) {
            System.out.println("XML file is not valid: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}