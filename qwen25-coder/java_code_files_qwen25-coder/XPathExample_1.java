import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

public class XPathExample_1 {
    public static void main(String[] args) {
        try {
            String xmlString = "<root><section name=\"blah\"><item name=\"asdf\">2222</item></section></root>";

            // Parse the XML string into a DOM Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new java.io.ByteArrayInputStream(xmlString.getBytes()));

            // Create XPath object
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Define the XPath expression
            String expression = "/root/section[@name=\"blah\"]/item";

            // Evaluate theexpression against the Document instance
            Element node = (Element) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);

            if (node != null) {
                System.out.println("Found item: " + node.getTextContent());
            } else {
                System.out.println("Node not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}