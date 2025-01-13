import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser_5_5 {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        String filename = "C:\\Users\\Documents\\test.xml";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(filename);
        Element root = doc.getDocumentElement();
        NodeList uriList = root.getElementsByTagName("uri");
        if (uriList.getLength() > 0) {
            Element uri = (Element) uriList.item(0);
            System.out.println(uri.getTextContent());
        } else {
            System.out.println("No 'uri' element found.");
        }
    }
}