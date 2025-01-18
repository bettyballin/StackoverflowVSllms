import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;

public class MyClass {
    public static void main(String[] args) throws Exception {
        String yourXMLFile = "path/to/your/xmlfile.xml";  // Specify the path to your XML file

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        dbf.setCoalescing(true);
        dbf.setExpandEntityReferences(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(yourXMLFile);  // parse the XML file
    }
}