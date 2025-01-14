import net.sf.saxon.s9api.*;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class SchemaValidator_1 {
    public static void main(String[] args) {
        try {
            // Create a Saxon Processor and SchemaManager
            Processor processor = new Processor(false);
            SchemaManager schemaManager = processor.getSchemaManager();

            // Load the XSD file
            File xsdFile = new File("your-schema.xsd");
            StreamSource xsdSource = new StreamSource(xsdFile);
            schemaManager.load(xsdSource);

            // Create SchemaValidator
            SchemaValidator validator = schemaManager.newSchemaValidator();

            // Validate XML file
            File xmlFile = new File("your-document.xml");
            StreamSource xmlSource = new StreamSource(xmlFile);
            validator.validate(xmlSource);

            System.out.println("XML is valid.");
        } catch (SaxonApiException e) {
            System.err.println("Validation error: " + e.getMessage());
        }
    }
}