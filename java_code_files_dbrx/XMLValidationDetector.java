import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

public class XMLValidationDetector {
    private static boolean checksForDTD(final String xml) throws IOException {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes())) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            // Note: the validation flag is set to false to make sure that an exception is thrown if any doctype declaration is found
            xmlReader.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
            xmlReader.parse(new InputSource(inputStream));
        } catch (SAXException e) {
            return true; // if a doctype was declared, exception will be thrown and 'true' is returned
        }
        return false; // If no exceptions are thrown, the XML does not contain any DTD definitions.
    }

    private static boolean checksForXSD(final String xml) throws IOException {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes())) {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            // Note: this feature will make sure that any inline XSD schemas can be properly read and not treated as default attributes.
            docFactory.setFeature("http://apache.org/xml/features/validation/schema", true);
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document xmlDoc = docBuilder.parse(inputStream);
            NodeList listOfElements = xmlDoc.getElementsByTagNameNS("*", "*"); // Get all elements in document
            for (int idx = 0; idx < listOfElements.getLength(); idx++) { // Iterate over each element and check if it is schema definition.
                Element elem = (Element) listOfElements.item(idx);
                String namespaceURI = elem.getNamespaceURI();
                final boolean hasDefaultNS = hasSchemaLocationAsAttribute(elem, true); // Checks for xmlns attribute with schema location info
                if ((namespaceURI != null && !namespaceURI.isEmpty()) || hasDefaultNS) {
                    return true;
                }
            }
        } catch (ParserConfigurationException | SAXException e) {
            // Handle exceptions, etc.
        }
        return false; // If no schema definitions were detected.
    }

    private static boolean hasSchemaLocationAsAttribute(Element elem, boolean includeDefaultNamespace) {
        String schemaLocation = elem.getAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "schemaLocation");
        String noNamespaceSchemaLocation = elem.getAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "noNamespaceSchemaLocation");
        if ((schemaLocation != null && !schemaLocation.isEmpty()) || (noNamespaceSchemaLocation != null && !noNamespaceSchemaLocation.isEmpty())) {
            return true;
        }
        // Optionally check for default namespace declaration
        if (includeDefaultNamespace) {
            String defaultNS = elem.getAttribute("xmlns");
            if (defaultNS != null && !defaultNS.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}