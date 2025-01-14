import java.lang.String;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XPathExample_11 {

    public static Node getCertById(Document document, String id) throws Exception {
        // Create an instance of XPath
        XPath xPath = XPathFactory.newInstance().newXPath();

        // Compile the XPath expression to select the cert with the given id
        XPathExpression expr = xPath.compile(String.format("//cert[@id='%s']", id));

        // Evaluate the expression on the document and get a Node as result
        Node node = (Node) expr.evaluate(document, XPathConstants.NODE);

        return node;
    }

    public static void main(String[] args) throws Exception {
        // Load the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("path/to/your/xmlfile.xml");

        // Get the cert with id 2
        Node certNode = getCertById(doc, "2");

        if (certNode != null) {
            System.out.println("Found cert: " + certNode.getNodeName() + " with ID: " + certNode.getAttributes().getNamedItem("id").getNodeValue());
        } else {
            System.out.println("No cert found with the specified id.");
        }
    }
}