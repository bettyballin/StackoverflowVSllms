import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.File;

public class XPathExample {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Create an XPath instance
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Define the XPath expression
            String expression = "(/bookstore/book[@location='US'])[1]";

            // Compile and evaluate the XPath expression
            Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);

            // Print the result
            System.out.println(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}