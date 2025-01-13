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
import org.xml.sax.SAXException;

public class CustomParser {
    public static void main(String[] stringArray) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("example.xml"));
        Element element = document.getDocumentElement();
        String string = element.getElementsByTagName("title").item(0).getTextContent();
        System.out.println("<html><body><h1>" + string + "</h1></body></html>");
    }
}
