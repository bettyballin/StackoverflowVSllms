import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPathProcessor {
    public static void main(String[] args) throws Exception {
        // Create a Document and XPath instance
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse("your_xml_file.xml");
        XPath xpath = XPathFactory.newInstance().newXPath();

        XPathExpression expr = xpath.compile("/config/a/b/*");
        Object o = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList list = (NodeList) o;

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // Process the element node
                System.out.println("Element Node: " + node.getNodeName());
            }
        }
    }
}