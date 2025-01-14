import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.ValidatorHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParseException;

public class XMLValidator_1 {
    public static void validate(InputSource input, String schemaLocation) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        if (schemaLocation.endsWith(".xsd")) { // Validate using XSD
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new StreamSource(schemaLocation));
            ValidatorHandler handler = schema.newValidatorHandler();
            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.setErrorHandler(new ErrorHandler() {
                public void warning(SAXParseException exception) throws SAXException {
                    // Implement warning handling
                    System.out.println("Warning: " + exception.getMessage());
                }

                public void error(SAXParseException exception) throws SAXException {
                    // Implement error handling
                    System.out.println("Error: " + exception.getMessage());
                }

                public void fatalError(SAXParseException exception) throws SAXException {
                    // Implement fatal error handling
                    System.out.println("Fatal Error: " + exception.getMessage());
                    throw exception; // Re-throw the exception
                }
            });
            xmlReader.parse(input);
        } else { // Assume DTD
            spf.setValidating(true);
            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setErrorHandler(new ErrorHandler() {
                public void warning(SAXParseException exception) throws SAXException {
                    // Implement warning handling
                    System.out.println("Warning: " + exception.getMessage());
                }

                public void error(SAXParseException exception) throws SAXException {
                    // Implement error handling
                    System.out.println("Error: " + exception.getMessage());
                }

                public void fatalError(SAXParseException exception) throws SAXException {
                    // Implement fatal error handling
                    System.out.println("Fatal Error: " + exception.getMessage());
                    throw exception; // Re-throw the exception
                }
            });
            xmlReader.parse(input);
        }
    }

    public static void main(String[] args) {
    }
}