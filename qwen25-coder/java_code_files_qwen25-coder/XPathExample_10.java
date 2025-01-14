import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import java.io.File;

public class XPathExample_10 {
    public static void main(String[] args) throws Exception {
        // Create a factory that is namespace-aware, but does not validate.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setFeature("http://xml.org/sax/features/disallow-doctype-decl", true); // Disallow DOCTYPE declaration
        dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false); // Do not load external DTDs
        dbf.setXIncludeAware(false);
        dbf.setExpandEntityReferences(false);

        // Parse the XML file into a DOM Document.
        DocumentBuilder db = dbf.newDocumentBuilder();
        File xmlFile = new File("yourfile.xml");
        Document document = db.parse(xmlFile);

        // Create XPath instance
        XPath xPath = XPathFactory.newInstance().newXPath();

        // Evaluate an XPath expression on the parsed XML
        String expression = "/root/element"; // your XPath expression here
        String result = xPath.evaluate(expression, document);
        System.out.println("Result: " + result);
    }
}