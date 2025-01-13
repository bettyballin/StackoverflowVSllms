import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class Main_713 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get a specific element's value
            NodeList nodeList = root.getElementsByTagName("someTag");
            Node node = nodeList.item(0);
            String someValue = node.getTextContent();

            System.out.println(someValue);
        } catch (Exception e) {
            // Handle parsing errors
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}