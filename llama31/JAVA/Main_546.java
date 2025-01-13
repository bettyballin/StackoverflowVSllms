import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Main_546 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        // Assuming the HTML document is a string for simplicity
        String htmlString = "<html><head></head><body></body></html>";

        // Parse the HTML string
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(htmlString.getBytes()));

        // Create a new script element
        Element script = doc.createElement("script");

        // Set the script content
        script.setTextContent("your JavaScript code here");

        // Add the script to the head of the document
        Node head = doc.getElementsByTagName("head").item(0);
        head.appendChild(script);

        // Output the modified document
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }
}