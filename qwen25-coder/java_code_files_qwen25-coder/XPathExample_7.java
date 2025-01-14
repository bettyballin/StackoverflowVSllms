import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;

public class XPathExample_7 {
    public static void main(String[] args) throws Exception {
        String xmlString = "<sample><a /><a /><a /><terminating /><a /><a /></sample>";
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new ByteArrayInputStream(xmlString.getBytes()));
        
        XPath xpath = XPathFactory.newInstance().newXPath();

        // First set of <a/> nodes
        NodeList firstSetNodes = (NodeList) xpath.evaluate("//sample/a[following-sibling::node()[1][name() != 'a']]", doc, XPathConstants.NODESET);
        System.out.println("First Set: " + nodeCount(firstSetNodes));

        // Second set of <a/> nodes
        NodeList secondSetNodes = (NodeList) xpath.evaluate("//sample/terminating/following-sibling::a", doc, XPathConstants.NODESET);
        System.out.println("Second Set: " + nodeCount(secondSetNodes));
    }

    private static String nodeCount(NodeList nodeList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            sb.append(node.toString()).append(", "); // Call toString() to append node
        }
        return sb.toString().replaceAll(", $", "");
    }
}