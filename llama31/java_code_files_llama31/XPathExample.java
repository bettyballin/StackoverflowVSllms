/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XPathExample {
    public static void main(String[] stringArray) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("example.xml"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            String string = "(/bookstore/book[@location='US'])[1]";
            Node node = (Node)xPath.compile(string).evaluate(document, XPathConstants.NODE);
            System.out.println(node);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
