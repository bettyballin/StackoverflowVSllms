import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDiff {
    public static void main(String[] args) throws Exception {
        // Parse both XML documents
        Document docA = parseXmlFile("xmlA.xml");
        Document docB = parseXmlFile("xmlB.xml");

        // Get the root elements
        Element rootA = docA.getDocumentElement();
        Element rootB = docB.getDocumentElement();

        // Perform a basic diff
        NodeList diffList = diff(rootA, rootB);

        // Store the differences in a structured format (e.g., XML or JSON)
        System.out.println("Differences:");
        for (int i = 0; i < diffList.getLength(); i++) {
            Node diffNode = diffList.item(i);
            System.out.println(diffNode.getNodeName() + ": " + diffNode.getNodeValue());
        }
    }

    // Basic diff algorithm (Longest Common Subsequence)
    public static NodeList diff(Element elemA, Element elemB) {
        NodeList childrenA = elemA.getChildNodes();
        NodeList childrenB = elemB.getChildNodes();

        NodeList diffList = elemA.getOwnerDocument().createNodeList();

        int i = 0;
        while (i < childrenA.getLength() && i < childrenB.getLength()) {
            Node childA = childrenA.item(i);
            Node childB = childrenB.item(i);

            if (childA.getNodeType() == Node.ELEMENT_NODE && childB.getNodeType() == Node.ELEMENT_NODE) {
                Element childElemA = (Element) childA;
                Element childElemB = (Element) childB;

                if (!childElemA.getTagName().equals(childElemB.getTagName())) {
                    // Tag name difference
                    diffList.add(createDiffNode(childElemA, childElemB));
                } else {
                    // Recursively diff child elements
                    NodeList childDiffList = diff(childElemA, childElemB);
                    for (int j = 0; j < childDiffList.getLength(); j++) {
                        diffList.add(childDiffList.item(j));
                    }
                }
            } else if (childA.getNodeType() == Node.TEXT_NODE && childB.getNodeType() == Node.TEXT_NODE) {
                // Text node difference
                if (!childA.getNodeValue().equals(childB.getNodeValue())) {
                    diffList.add(createDiffNode(childA, childB));
                }
            }

            i++;
        }

        return diffList;
    }

    // Create a diff node to store the differences
    public static Node createDiffNode(Node nodeA, Node nodeB) {
        Node diffNode = nodeA.getOwnerDocument().createElement("diff");

        // Store the differences in the diff node
        diffNode.appendChild(nodeA.getOwnerDocument().createTextNode("Old value: " + nodeA.getNodeValue()));
        diffNode.appendChild(nodeA.getOwnerDocument().createTextNode("New value: " + nodeB.getNodeValue()));

        return diffNode;
    }

    // Parse an XML file into a Document object
    public static Document parseXmlFile(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder().parse(new File(filePath));
    }
}