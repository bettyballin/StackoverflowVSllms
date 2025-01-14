import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class XMLDTDValidationExample {
    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xmlfile.xml";
        String dtdFilePath = "/path/to/your/dtdfile.dtd";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // Enable DTD validation
            dbf.setValidating(true);
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", true);
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            // Create DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Specify the DTD to use
            db.setEntityResolver((publicId, systemId) -> new InputSource(dtdFilePath));

            // Set the ErrorHandler for validation errors
            db.setErrorHandler(new ErrorHandler() {
                public void warning(SAXParseException exception) {
                    System.err.println("Warning: " + exception.getMessage());
                }
                public void error(SAXParseException exception) throws SAXException {
                    throw new RuntimeException("Error: ", exception);
                }
                public void fatalError(SAXParseException exception) throws SAXException {
                    throw new RuntimeException("Fatal Error: ", exception);
                }
            });

            // Parse the XML file, validation is performed during parsing
            Document doc = db.parse(new File(xmlFilePath));
            System.out.println("XML is valid against the specified DTD.");

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}