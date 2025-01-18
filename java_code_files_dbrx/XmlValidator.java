import java.lang.String;
import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import org.xml.sax.SAXException;

public class XmlValidator {
    public static void main(String[] args) throws SAXException, IOException {
        // Paths to XML and XSD files.
        File xmlFile = new File("path/to/your_file.xml");
        File xsdFile = new File("path/to/your_schema.xsd");

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdFile));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            System.out.println("The XML file is valid.");
        } catch (SAXException | IOException e) {
            System.err.printf("Unable to validate the document: %s", e);
        }
    }
}