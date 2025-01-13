import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.File;
import java.io.IOException;

public class XmlValidator_4 {
    public static void main(String[] args) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(new File("path/to/your/schema.xsd"));
            Validator validator = schema.newValidator();

            // Create a custom ErrorHandler implementation
            ErrorHandler errorHandler = new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    // Handle warnings
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    // Handle fatal errors
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    // Handle errors, e.g., by logging or throwing a custom exception
                    System.out.println("Validation error at line " + exception.getLineNumber() + ", column " + exception.getColumnNumber() + ": " + exception.getMessage());
                }
            };

            validator.setErrorHandler(errorHandler);

            // Validate your XML document
            Source source = new StreamSource(new File("path/to/your/xml.xml"));
            validator.validate(source);
        } catch (SAXException | IOException e) {
            System.out.println("Error validating XML: " + e.getMessage());
        }
    }
}