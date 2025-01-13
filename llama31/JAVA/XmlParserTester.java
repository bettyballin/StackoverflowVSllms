import java.io.StringReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class XmlParserTester {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLReader reader = parser.getXMLReader();

        String testChunk2 = "<e1>text</e1><e2>text</e2>";
        InputSource is = new InputSource(new StringReader(testChunk2));

        reader.parse(is);
    }
}