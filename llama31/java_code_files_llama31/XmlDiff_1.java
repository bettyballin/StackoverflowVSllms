/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlDiff_1 {
    public static void main(String[] stringArray) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("file1.xml"));
        Document document2 = documentBuilder.parse(new File("file2.xml"));
        NodeList nodeList = document.getElementsByTagName("*");
        NodeList nodeList2 = document2.getElementsByTagName("*");
        if (nodeList.getLength() != nodeList2.getLength()) {
            System.out.println("Different number of elements");
        }
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Element element = (Element)nodeList.item(i);
            Element element2 = (Element)nodeList2.item(i);
            if (element.getTagName().equals(element2.getTagName())) continue;
            System.out.println("Different element names");
        }
    }
}
