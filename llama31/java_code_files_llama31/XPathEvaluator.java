/*
 * Decompiled with CFR 0.152.
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathEvaluator {
    public static void main(String[] stringArray) throws Exception {
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression xPathExpression = xPath.compile("/config/a/b");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = documentBuilderFactory.newDocumentBuilder().parse("your_xml_file.xml");
        Object object = xPathExpression.evaluate(document, XPathConstants.NODESET);
        NodeList nodeList = (NodeList)object;
        for (int i = 0; i < nodeList.getLength(); ++i) {
            System.out.println(nodeList.item(i).getTextContent());
        }
    }
}
