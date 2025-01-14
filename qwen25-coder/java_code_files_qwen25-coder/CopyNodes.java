import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.util.List;
import java.util.ArrayList;

public class CopyNodes {
    public static void main(String[] args) throws Exception {
        // Create a sample source document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document sourceDoc = builder.newDocument();
        Element root = sourceDoc.createElement("root");
        sourceDoc.appendChild(root);

        // Create some nodes to copy
        Element child1 = sourceDoc.createElement("child1");
        root.appendChild(child1);
        Element child2 = sourceDoc.createElement("child2");
        root.appendChild(child2);

        // List of nodes to copy
        List<Node> nodesToCopy = new ArrayList<Node>();
        nodesToCopy.add(child1);
        nodesToCopy.add(child2);

        // The document to which nodes will be copied
        Document newDoc = builder.newDocument();
        Element newRoot = newDoc.createElement("newRoot");
        newDoc.appendChild(newRoot);

        for (Node n : nodesToCopy) {
            Node importedNode = newDoc.importNode(n, true); // 'true' means deep import including children
            newDoc.getDocumentElement().appendChild(importedNode); // Append the node to your target element
        }

        // For demonstration, output the new document to System.out
        javax.xml.transform.TransformerFactory tfactory = javax.xml.transform.TransformerFactory.newInstance();
        javax.xml.transform.Transformer transformer = tfactory.newTransformer();
        javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(newDoc);
        javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(System.out);
        transformer.transform(source, result);
    }
}