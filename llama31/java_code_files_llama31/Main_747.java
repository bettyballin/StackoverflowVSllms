/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

public class Main_747 {
    public static void main(String[] stringArray) throws Exception {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        String string = "//span[@id='important-data']/text()";
        String string2 = "<html><body><span id='important-data'>Hello, World!</span></body></html>";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string2.getBytes("UTF-8"));
        Document document = documentBuilder.parse(byteArrayInputStream);
        String string3 = (String)xPath.evaluate(string, document, XPathConstants.STRING);
        System.out.println(string3);
    }
}
