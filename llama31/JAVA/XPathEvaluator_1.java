import java.io.StringReader;
import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class XPathEvaluator_1_1 {
    public static Node getCert(Document document, String id) throws Exception {
        XPath xPath = XPathFactory.newInstance().newXPath();
        String xpathExpression = "/root/cert[@id='" + id + "']";
        Node certNode = (Node) xPath.evaluate(xpathExpression, document, XPathConstants.NODE);
        return certNode;
    }

    public static void main(String[] args) throws Exception {
        String xml = "<root><cert id='1'/><cert id='2'/><cert id='3'/></root>";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = factory.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
        Node certNode = getCert(document, "2");
        System.out.println(certNode.getNodeName()); // prints "cert"
    }
}