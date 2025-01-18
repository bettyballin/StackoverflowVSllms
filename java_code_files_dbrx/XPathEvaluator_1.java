import java.lang.String;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPathEvaluator_1 {

    private Document document;

    public String getNodeValueOrNA(String xpathExpression) {
        try {
            final XPathFactory factory = XPathFactory.newInstance();
            final XPath xpath = factory.newXPath();
            // Compile the expression to get a XPathExpression object.
            final XPathExpression expr = xpath.compile(xpathExpression);

            NodeList result = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            // Check if nodes exists and then return value or "N/A" based on its existence.
            Node firstNode = getFirstNonTextChildNode(result);
            if (firstNode != null) {
                return result.getLength() > 0 ? String.valueOf(firstNode) : "N/A";
            } else {
                // If node is missing then return N/A;
                return "N/A";
            }
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

    private Node getFirstNonTextChildNode(NodeList nodeList) {
        if (nodeList == null)
            return null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() != Node.TEXT_NODE) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
    }
}