import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XPathExample_6_6 {

    public static void main(String[] args) throws Exception {
        // Load the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = factory.newDocumentBuilder().parse("example.xml");

        // Create an XPath instance
        XPath xPath = XPathFactory.newInstance().newXPath();

        // Extract the element using XPath expression
        String xpathExpression = "/root/element"; // Replace with your XPath expression
        Node element = (Node) xPath.compile(xpathExpression).evaluate(document, XPathConstants.NODE);

        // Print the extracted element
        System.out.println(element.getTextContent());
    }
}