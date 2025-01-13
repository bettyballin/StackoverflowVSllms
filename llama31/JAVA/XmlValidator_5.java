import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class XmlValidator_5_5 {
    public static void main(String[] args) {
        String xmlFile = "path/to/your/xml/file.xml";
        String xsdFile = "path/to/your/xsd/file.xsd";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();

            // Set the XSD schema for validation
            reader.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
            reader.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource", xsdFile);

            // Create a handler to capture validation errors
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void error(SAXParseException e) throws SAXException {
                    System.out.println("Validation error: " + e.getMessage());
                }

                @Override
                public void fatalError(SAXParseException e) throws SAXException {
                    System.out.println("Fatal validation error: " + e.getMessage());
                }

                @Override
                public void warning(SAXParseException e) throws SAXException {
                    System.out.println("Validation warning: " + e.getMessage());
                }
            };

            // Parse and validate the XML file
            reader.setContentHandler(handler);
            reader.parse(new InputSource(new FileInputStream(new File(xmlFile))));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}