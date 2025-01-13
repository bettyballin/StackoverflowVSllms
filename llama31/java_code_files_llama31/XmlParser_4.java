/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlParser_4 {
    public static void main(String[] stringArray) {
        String string = "<your-xml-string-here>";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(string));
            Document document = documentBuilder.parse(inputSource);
        }
        catch (IOException | ParserConfigurationException | SAXException exception) {
            // empty catch block
        }
    }
}
