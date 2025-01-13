import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Node;

public class XmlParser_2_2 {
    Node level2Node;
    Node cdataNode;
    String cdataContent;

    public XmlParser_2(Node myNodeList) {
        // assuming inFeed.getXpath() returns an XPath object
        // also assuming myNodeList is a NodeList
        level2Node = (Node) inFeed.getXpath().evaluate("xml/level1/level2", myNodeList, XPathConstants.NODE);
        cdataNode = level2Node.getFirstChild();
        cdataContent = cdataNode.getNodeValue();
    }

    public static void main(String[] args) {
        // create a new XmlParser_2 instance with a NodeList
        // e.g. XmlParser_2 parser = new XmlParser_2(myNodeList);
    }
}