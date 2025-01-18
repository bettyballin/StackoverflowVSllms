import java.io.File;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XmlParserorXmlNodeExtractor {
    public static void main(String[] args) throws Exception {
        //Using DOM
        Document document = new SAXReader().read(new File("file.xml")); // Read xml file
        List<Element> childNodes = document.getRootElement().elements(); // Get all childNodes

        //Using XPath
        String xpathExpression = "/root/childNode"; // Create your expression to get the desired node
        List<Node> nodes = document.selectNodes(xpathExpression); // Get all childNodes
    }
}