/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main_713 {
    public static void main(String[] stringArray) {
        try {
            File file = new File("config.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            Element element = document.getDocumentElement();
            NodeList nodeList = element.getElementsByTagName("someTag");
            Node node = nodeList.item(0);
            String string = node.getTextContent();
            System.out.println(string);
        }
        catch (Exception exception) {
            System.out.println("Error parsing XML: " + exception.getMessage());
        }
    }
}
