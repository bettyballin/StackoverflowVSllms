import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

public class XMLParserExample_1 {
    public static void main(String[] args) {
        try {
            // Load and parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("file:///path/to/your/file.xml");

            // Create an XPathFactory and an XPath object
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // Compile the XPath expression (change "/root/element" to your element path)
            String expression = "/root/element";
            NodeList nodeList = (NodeList) xpath.compile(expression).evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    // Print the value of the element
                    System.out.println(eElement.getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}