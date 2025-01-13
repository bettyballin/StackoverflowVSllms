import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class FontMetricsParser {
    public static void main(String[] args) {
        try {
            File inputFile = new File("font-metrics.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("font-triplet");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Font Name: " + eElement.getAttribute("name"));
                    System.out.println("Font Style: " + eElement.getAttribute("style"));
                    System.out.println("Font Weight: " + eElement.getAttribute("weight"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}