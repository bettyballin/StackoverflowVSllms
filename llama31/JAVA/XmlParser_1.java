import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;

public class XmlParser_1_1 {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);
        factory.setValidating(false);

        DocumentBuilder builder = factory.newDocumentBuilder();
        String testChunk2 = "<e1>text</e1><e2>text</e2>";
        InputSource is = new InputSource(new StringReader(testChunk2));

        Document doc = builder.parse(is);
    }
}