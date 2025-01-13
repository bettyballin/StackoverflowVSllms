import org.apache.xpath.XPathAPI;
import org.apache.xpath.XPathEvaluator;
import org.apache.xpath.XPathExpression;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class Main_614 {
    public static void main(String[] args) throws Exception {
        // Create an XPathEvaluator instance
        XPathEvaluator evaluator = new XPathEvaluator();

        // Compile an XPath expression
        XPathExpression expression = evaluator.compile("/root/node");

        // Evaluate the XPath expression on a String containing XML
        String xml = "<root><node>value</node></root>";
        Node result = (Node) expression.evaluate(new InputSource(new StringReader(xml)));

        // Print the result
        System.out.println(result.getTextContent());
    }
}