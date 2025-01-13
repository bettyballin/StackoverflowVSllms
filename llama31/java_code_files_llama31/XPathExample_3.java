/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathExample_3 {
    public static void main(String[] stringArray) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = documentBuilderFactory.newDocumentBuilder().parse(new File("yourfile.xml"));
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList)xPath.evaluate("//div[@class='example']", document, XPathConstants.NODESET);
        System.out.println("Number of nodes: " + nodeList.getLength());
    }
}
