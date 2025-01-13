import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathEvaluator_2_2 {
    public static void main(String[] args) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("input.xml");
        
        String xpath_string = "//*[@id='catlisting']//a";
        XPath xpath = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xpath.compile(xpath_string);

        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("size=" + nodes.getLength());
        for (int r = 0; r < nodes.getLength(); r++) {
            System.out.println(nodes.item(r).getTextContent());
        }
    }
}