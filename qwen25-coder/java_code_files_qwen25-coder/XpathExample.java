import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.w3c.dom.Document;

public class XpathExample {
    public static void main(String[] args) throws Exception {
        // Assume 'document' is your loaded XML Document
        Document document = null;

        String xpathExpression = "/xml/level1/level2";

        XPath xPath = XPathFactory.newInstance().newXPath();
        Node node = (Node) xPath.evaluate(xpathExpression, document, XPathConstants.NODE);

        if (node != null) {
            // This will output the exact content including HTML tags
            String cdataContent = node.getTextContent();
            System.out.println(cdataContent);  // Output: Release Date: 11/20/09 <br />View Trailer 
        }
    }
}