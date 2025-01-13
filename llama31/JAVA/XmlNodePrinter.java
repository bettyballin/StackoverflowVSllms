import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class XmlNodePrinter {
    public static void printNodeList(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getTextContent());
        }
    }

    public static void main(String[] args) {
        // You would need to create a NodeList and populate it with nodes to print
        // For demonstration purposes, this is left empty
    }
}