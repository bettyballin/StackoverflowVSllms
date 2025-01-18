import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

public class XPathEvaluator {

    String title = "Book A";
    Document xmlDoc = null; // assuming 'xmlDoc' is a handle for the parsed xml doc
    XPath xpath;
    NodeList attributes;

    public XPathEvaluator() throws XPathExpressionException {
        xpath = XPathFactory.newInstance().newXPath();
        attributes = (NodeList) xpath.evaluate("attr[text()='" + title + "']/preceding-sibling::*", xmlDoc, XPathConstants.NODESET);
    }

    public static void main(String[] args) throws Exception {
        new XPathEvaluator();
    }
}