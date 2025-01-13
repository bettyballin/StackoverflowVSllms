import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class NodeCloner {
    public static void main(String[] args) throws Exception {
        // Create a new document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document newDoc = builder.newDocument();

        // Assuming nodesToCopy is a NodeList containing nodes to be copied
        NodeList nodesToCopy = null; // You need to get this from somewhere

        for (int i = 0; i < nodesToCopy.getLength(); i++) {
            Node n = nodesToCopy.item(i);
            Element newElement = newDoc.createElement(n.getNodeName());
            NamedNodeMap attributes = n.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                Attr attribute = (Attr) attributes.item(j);
                newElement.setAttribute(attribute.getName(), attribute.getValue());
            }
            NodeList childNodes = n.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node childNode = childNodes.item(j);
                newElement.appendChild(newDoc.importNode(childNode, true));
            }
            newDoc.appendChild(newElement);
        }

        // Save the new document to a file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(newDoc);
        StreamResult result = new StreamResult(new File("output.xml"));
        transformer.transform(source, result);
    }
}