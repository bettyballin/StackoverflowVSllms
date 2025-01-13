import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Main_651 {
    public static void main(String[] args) throws Exception {
        // Load the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("example.xml");

        // Create an XPath instance
        XPath xPath = XPathFactory.newInstance().newXPath();

        // Evaluate the XPath expression
        String expression = "//example";
        NodeList nodes = (NodeList) xPath.evaluate(expression, document, XPathConstants.NODESET);
    }
}