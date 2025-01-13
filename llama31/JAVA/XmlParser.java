import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParser {
    public static void main(String[] args) {
        // You need to get the NodeList from an XML document
        // Here, we assume that you have a NodeList named "nodes"
        NodeList nodes = null; // Replace with your actual NodeList

        if (nodes != null) {
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Node textNode = node.getFirstChild();
                    if (textNode != null && textNode.getNodeType() == Node.TEXT_NODE) {
                        System.out.println(textNode.getNodeValue());
                    }
                }
            }
        }
    }
}