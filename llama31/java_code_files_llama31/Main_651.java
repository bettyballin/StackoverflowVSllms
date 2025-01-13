/*
 * Decompiled with CFR 0.152.
 */
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Main_651 {
    public static void main(String[] stringArray) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("example.xml");
        XPath xPath = XPathFactory.newInstance().newXPath();
        String string = "//example";
        NodeList nodeList = (NodeList)xPath.evaluate(string, document, XPathConstants.NODESET);
    }
}
