import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.*;

public class XPathExample {
    public static void main(String[] args) throws Exception {
        // Initialize the Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("input.xml");

        XPath xpath = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xpath.compile("/config/a/b/param"); // Adjusted XPath expression
        Object o = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList list = (NodeList) o;
        
        // Now 'list' should only contain the <param> elements.
        // You can process 'list' as needed. For example:
        for (int i = 0; i < list.getLength(); i++) {
            Node paramNode = list.item(i);
            System.out.println("Element: " + paramNode.getNodeName() + ", Value: " + paramNode.getTextContent());
        }
    }
}