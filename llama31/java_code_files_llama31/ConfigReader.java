/*
 * Decompiled with CFR 0.152.
 */
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConfigReader {
    public static void main(String[] stringArray) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("config.xml");
            NodeList nodeList = document.getElementsByTagName("setting");
            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);
                if (node.getNodeType() != 1) continue;
                Element element = (Element)node;
                System.out.println("Setting: " + element.getAttribute("name") + " = " + element.getTextContent());
            }
        }
        catch (Exception exception) {
            System.out.println("Error parsing XML: " + exception.getMessage());
        }
    }
}
