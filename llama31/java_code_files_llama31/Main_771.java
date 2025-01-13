/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Main_771 {
    public static void main(String[] stringArray) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            Document document = documentBuilderFactory.newDocumentBuilder().parse("example.xml");
            XPath xPath = XPathFactory.newInstance().newXPath();
            String string = "/root/node[@id='1']/name";
            Node node = (Node)xPath.evaluate(string, document, XPathConstants.NODE);
            System.out.println(node.getTextContent());
        }
        catch (IOException | ParserConfigurationException | XPathExpressionException | SAXException exception) {
            System.err.println("Error: " + exception.getMessage());
        }
    }
}
