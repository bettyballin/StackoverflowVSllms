import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlValidator_1 {
    DocumentBuilderFactory factory;
    DocumentBuilder builder;

    public XmlValidator_1() throws Exception {
        factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // enables validation for well-formedness and DTDs/Schemas

        // Create a builder that validates the input based on given DTD or Schema (if any)
        builder = factory.newDocumentBuilder();
        builder.setErrorHandler(new SimpleErrorHandler());
    }

    public static void main(String[] args) throws Exception {
        new XmlValidator_1();
    }
    
    class SimpleErrorHandler implements ErrorHandler {
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: ");
            printInfo(e);
        }

        public void error(SAXParseException e) throws SAXException {
            System.out.println("Error: ");
            printInfo(e);
        }

        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("Fatal error: ");
            printInfo(e);
        }

        private void printInfo(SAXParseException e) {
            System.out.println("   Public ID: " + e.getPublicId());
            System.out.println("   System ID: " + e.getSystemId());
            System.out.println("   Line number: " + e.getLineNumber());
            System.out.println("   Column number: " + e.getColumnNumber());
            System.out.println("   Message: " + e.getMessage());
        }
    }
}