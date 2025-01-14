import java.lang.String;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseXML {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("timelog.xml");
            NodeList nodes = document.getElementsByTagName("timecommand");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                System.out.println("Command: " + element.getAttribute("cmd"));
                System.out.println("Date: " + element.getAttribute("date"));
                System.out.println("Time: " + element.getAttribute("time"));
                System.out.println("Project: " + element.getAttribute("proj"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}