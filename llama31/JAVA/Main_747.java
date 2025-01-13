import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.ByteArrayInputStream;

public class Main_747 {
    public static void main(String[] args) throws Exception {
        // Create an XPath factory
        XPathFactory factory = XPathFactory.newInstance();

        // Create an XPath object
        XPath xpath = factory.newXPath();

        // Define the XPath expression
        String expression = "//span[@id='important-data']/text()";

        // Get the HTML content
        String html = "<html><body><span id='important-data'>Hello, World!</span></body></html>";

        // Parse the HTML content into a Document object
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        ByteArrayInputStream input = new ByteArrayInputStream(html.getBytes("UTF-8"));
        Document document = builder.parse(input);

        // Evaluate the XPath expression
        String data = (String) xpath.evaluate(expression, document, XPathConstants.STRING);

        System.out.println(data);
    }
}