import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XSDValidator {
    public static void main(String[] args) {
        try {
            // Load the XSD schema
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(new File("your_schema.xsd"));

            // Validate the XML file
            Validator validator = schema.newValidator();
            ValidationEventCollector collector = new ValidationEventCollector();
            validator.setErrorHandler(collector);
            Source source = new StreamSource(new File("your_xml_file.xml"));
            validator.validate(source);

            // Check for validation errors
            if (collector.getEvents().size() > 0) {
                System.out.println("Validation failed");
            } else {
                System.out.println("Validation succeeded");
            }
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}