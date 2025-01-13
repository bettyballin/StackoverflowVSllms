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

public class Main_798 {
    public static void main(String[] stringArray) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("books.xml"));
        XPath xPath = XPathFactory.newInstance().newXPath();
        String string = "//author[contains(text(), 'Ritchie')]/text()";
        String string2 = (String)xPath.compile(string).evaluate(document, XPathConstants.STRING);
        System.out.println(string2);
    }
}
