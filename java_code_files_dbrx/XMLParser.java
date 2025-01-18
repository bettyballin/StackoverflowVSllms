import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class XMLParser {
    private String yourXMLString;

    public Document parse() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inputSource = new InputSource(new StringReader(yourXMLString));
        return builder.parse(inputSource);
    }

    public static void main(String[] args) {
    }
}