import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpression;
import org.w3c.dom.Node;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XPathExample_12 {
    public static void main(String[] args) throws Exception {
        // Assume 'document' is your DOM Document object and 'expression' is the XPath expression

        // Sample XML content
        String xmlString = "<root><element>Hello, World!</element></root>";
        
        // Parse the XML string into a Document object
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new java.io.ByteArrayInputStream(xmlString.getBytes("UTF-8")));
        
        // XPath expression
        String expression = "/root/element";
        
        // Create XPath
        XPath xPath = XPathFactory.newInstance().newXPath();
        
        // Evaluate the XPath expression
        Node node = (Node) xPath.evaluate(expression, document, javax.xml.xpath.XPathConstants.NODE);
        System.out.println(node.getTextContent());
    }
}