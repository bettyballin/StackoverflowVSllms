import java.lang.String;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

public class ModifyXmlDocument {

    public static void main(String[] args) {
        try {
            // Load existing XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("path/to/your/xmlfile.xml");

            // Create XPath object to locate the node
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Select the <location> element, if it exists
            Node locationNode = (Node) xpath.evaluate("//customdata/location", doc, XPathConstants.NODE);

            if (locationNode != null) {
                // If the <location> tag is found, replace its text content
                locationNode.setTextContent("http://something");
            } else {
                // Otherwise, create a new <location> element and append it under <customdata>
                Element customdataElement = doc.getDocumentElement(); // Assuming <customdata> is the root or you can refine the XPath
                Element newLocationNode = doc.createElement("location");
                newLocationNode.setTextContent("http://something");
                customdataElement.appendChild(newLocationNode);
            }

            // Output the modified XML document to a file or console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);  // can replace with an output file stream if needed
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}