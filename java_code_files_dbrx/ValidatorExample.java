import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class ValidatorExample {
    public static void main(String[] args) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            File xsd = new File("myfile.xsd");
            Source schemaDocument = new StreamSource(xsd);
            Schema schema = schemaFactory.newSchema(schemaDocument);

            Validator validator = schema.newValidator();

            validator.setErrorHandler(new ErrorHandler() {
                public void warning(SAXParseException exception) throws SAXException {
                    // Handle warnings
                    System.out.println("Warning: " + exception.getMessage());
                }

                public void error(SAXParseException exception) throws SAXException {
                    // Handle errors
                    System.out.println("Error: " + exception.getMessage());
                    throw exception;
                }

                public void fatalError(SAXParseException exception) throws SAXException {
                    // Handle fatal errors
                    System.out.println("Fatal error: " + exception.getMessage());
                    throw exception;
                }
            });

            validator.validate(new StreamSource("myfile.xml"));
            System.out.println("Validation successful.");
        } catch (SAXException e) {
            System.out.println("Validation failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
    }
}