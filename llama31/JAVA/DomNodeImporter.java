import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DomNodeImporter {

    public static void main(String[] args) throws ParserConfigurationException {
        // Assuming nodesToCopy is somehow populated or available
        // For demonstration, let's create an empty list
        NodeList nodesToCopy = null; // You need to populate this

        // Create a new document
        Document newDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        // Your original loop
        if (nodesToCopy != null) {
            for (int i = 0; i < nodesToCopy.getLength(); i++) {
                Node n = nodesToCopy.item(i);
                Node clonedNode = n.cloneNode(true);
                Node importedNode = newDoc.importNode(clonedNode, true);
                newDoc.appendChild(importedNode);
            }
        }

        // Optionally, add some code to output newDoc for verification
    }
}