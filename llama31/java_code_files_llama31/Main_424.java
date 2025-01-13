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

public class Main_424 {
    public static void main(String[] stringArray) throws Exception {
        String string = "programming questions site";
        String string2 = "//a[text()='" + string + "']/@href";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("your-html-file.html"));
        XPath xPath = XPathFactory.newInstance().newXPath();
        String string3 = (String)xPath.evaluate(string2, document, XPathConstants.STRING);
        System.out.println(string3);
    }
}
