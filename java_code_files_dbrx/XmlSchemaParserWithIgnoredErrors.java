import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import java.io.IOException;

public class XmlSchemaParserWithIgnoredErrors {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true); // Enable namespace awareness
            factory.setValidating(true); // Enable validation
            factory.setFeature("http://apache.org/xml/features/validation/schema", true);

            SAXParser parser = factory.newSAXParser();

            XMLReader reader = parser.getXMLReader();
            reader.setErrorHandler(new IgnoringErrorHandler()); // Use your own Error Handler to ignore warnings and fatal errors related to IDREFs
            reader.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
                               "http://www.w3.org/2001/XMLSchema");

            reader.parse(new InputSource("your_file"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Custom ErrorHandler that ignores warnings and errors
    public static class IgnoringErrorHandler implements ErrorHandler {
        @Override
        public void warning(SAXException exception) throws SAXException {
            // Ignore warnings
        }

        @Override
        public void error(SAXException exception) throws SAXException {
            // Ignore errors
        }

        @Override
        public void fatalError(SAXException exception) throws SAXException {
            // Ignore fatal errors related to IDREFs
        }
    }
}