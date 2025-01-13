import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class Main_613 {
    public static void main(String[] args) throws Exception {
        // Create a non-validating DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);

        // Create an XPath instance
        XPath xPath = XPathFactory.newInstance().newXPath();

        // Compile an XPath expression
        XPathExpression expression = xPath.compile("/root/node");

        // Evaluate the XPath expression on a String containing XML
        String xml = "<root><node>value</node></root>";
        InputSource source = new InputSource(new StringReader(xml));
        Node result = (Node) expression.evaluate(source, XPathConstants.NODE);

        // Print the result
        System.out.println(result.getTextContent());
    }
}