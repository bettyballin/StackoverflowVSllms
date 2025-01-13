import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;

public class JDomParser {
    public static void main(String[] args) throws IOException, SAXException {
        String filename = "C:\\Users\\Documents\\test.xml";
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(filename);
        Element root = doc.getRootElement();
        Element uri = root.getChild("uri");
        System.out.println(uri.getValue());
    }
}