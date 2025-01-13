import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathExample_2 {
    public static void main(String[] args) throws Exception {
        // Load the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = factory.newDocumentBuilder().parse("example.xml");

        // Create an XPath expression
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression expression = xPath.compile("//Menu[Name='Sub Menu']/Document");

        // Evaluate the XPath expression
        NodeList nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);

        // Print the results
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getTextContent());
        }
    }
}