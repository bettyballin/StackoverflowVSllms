/*
 * Decompiled with CFR 0.152.
 */
import java.io.StringReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class XmlParserTester {
    public static void main(String[] stringArray) throws Exception {
        SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
        SAXParser sAXParser = sAXParserFactory.newSAXParser();
        XMLReader xMLReader = sAXParser.getXMLReader();
        String string = "<e1>text</e1><e2>text</e2>";
        InputSource inputSource = new InputSource(new StringReader(string));
        xMLReader.parse(inputSource);
    }
}
