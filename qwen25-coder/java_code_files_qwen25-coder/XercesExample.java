// Example of using Xerces to parse XML
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class XercesExample {
    public static void main(String[] args) throws Exception {
        DOMParser parser = new DOMParser();
        parser.parse("yourfile.xml");
        Document document = parser.getDocument();
    }
}