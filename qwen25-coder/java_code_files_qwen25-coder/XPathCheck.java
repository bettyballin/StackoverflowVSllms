import java.lang.String;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XPathCheck {
    public static void main(String[] args) throws Exception {
        // Parse the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("yourwebpage.html");

        // Create an XPathFactory and XPath object
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        // Check for presence of /html/body
        String bodyExpression = "/html/body";
        boolean bodyExists = (Boolean) xpath.evaluate(bodyExpression, doc, XPathConstants.BOOLEAN);
        
        // Check for presence of /html/head/title
        String titleExpression = "/html/head/title";
        boolean titleExists = (Boolean) xpath.evaluate(titleExpression, doc, XPathConstants.BOOLEAN);

        System.out.println("Body exists: " + bodyExists);
        System.out.println("Title exists: " + titleExists);
    }
}