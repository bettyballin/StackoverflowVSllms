import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.IOException;

import org.xml.sax.SAXException; // This import was missing

public class Main_771 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document document = factory.newDocumentBuilder().parse("example.xml");

            // Create an XPath instance
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Query the XML document using XPath
            String query = "/root/node[@id='1']/name";
            Node result = (Node) xPath.evaluate(query, document, XPathConstants.NODE);

            // Print the result
            System.out.println(result.getTextContent());
        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}