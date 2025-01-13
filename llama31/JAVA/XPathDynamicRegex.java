import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class XPathDynamicRegex {
    public static void main(String[] args) throws Exception {
        String input = "AMAZON"; // Change this to test with different inputs
        String xpathExpression = "/Configuration/Destinations/Destination[(From[matches(., '^" + input + ".*') or . = '" + input + "'] or From = '*')]/@name";

        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression expression = xPath.compile(xpathExpression);

        // Create a Document object
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("your_xml_file.xml"); // Replace with your XML file

        Object result = expression.evaluate(doc, XPathConstants.NODESET);
        // Process the result
    }
}