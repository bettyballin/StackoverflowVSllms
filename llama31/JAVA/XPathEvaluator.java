import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathEvaluator {
    public static void main(String[] args) throws Exception {
        // Create a new XPath instance
        XPath xpath = XPathFactory.newInstance().newXPath();

        // Compile the XPath expression
        XPathExpression expr = xpath.compile("/config/a/b");

        // Load the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse("your_xml_file.xml");

        // Evaluate the XPath expression
        Object o = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList list = (NodeList) o;

        // Print the result
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.item(i).getTextContent());
        }
    }
}