import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.XMLConstants;
import org.w3c.dom.Document;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Source;

public class XmlSchemaValidator {

    public static void main(String[] args) {
        try {
            // Load the XML Schema
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("your-schema.xsd")); // Replace "your-schema.xsd" with your actual XSD file path

            // Create a Validator
            Validator validator = schema.newValidator();

            // Parse the XML file into a Document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("example.xml")); // Replace "example.xml" with your XML file path

            // Validate the DOM tree
            Source input = new DOMSource(doc);

            validator.validate(input);

            System.out.println("Validation succeeded.");
        } catch (SAXException e) {
            System.err.println("Validation failed: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}