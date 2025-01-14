import java.lang.String;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidation {
    public static void main(String[] args) {
        try {
            // Create a SchemaFactory capable of understanding WXS schemas.
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Load a schema file.
            File schemaFile = new File("path/to/your/schema.xsd");
            javax.xml.validation.Schema schema = factory.newSchema(schemaFile);

            // Create a Validator for validating XML content against this schema.
            Validator validator = schema.newValidator();

            // Validate the XML document.
            StreamSource xmlStream = new StreamSource(new File("path/to/your/xmlfile.xml"));
            validator.validate(xmlStream);
            System.out.println("XML is valid");

        } catch (Exception e) {
            System.err.println("XML is NOT valid");
            System.err.println(e.getMessage());
        }
    }
}