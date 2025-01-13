import java.lang.String;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;

public class XMLValidator {

    public boolean validateXML(InputStream xmlInputStream) {
        try {
            // Load the XMLSchema from the classpath
            InputStream schemaInputStream = getClass().getResourceAsStream("/path/to/config.xsd");
            if (schemaInputStream == null) {
                throw new RuntimeException("Could not find schema resource");
            }

            // Create a SchemaFactory instance
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Create schema from the schema InputStream
            Schema schema = factory.newSchema(new StreamSource(schemaInputStream));

            // Create a Validator from the schema
            Validator validator = schema.newValidator();

            // Validate the XML
            validator.validate(new StreamSource(xmlInputStream));

            // If no exception was thrown, the XML is valid
            return true;
        } catch (Exception e) {
            // Handle validation exceptions
            System.err.println("XML is invalid: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        XMLValidator validator = new XMLValidator();
        // Example usage. Here, you would replace this with your actual XML InputStream
        InputStream xmlInputStream = validator.getClass().getResourceAsStream("/path/to/example.xml");
        boolean isValid = validator.validateXML(xmlInputStream);
        System.out.println("Is XML valid? " + isValid);
    }
}