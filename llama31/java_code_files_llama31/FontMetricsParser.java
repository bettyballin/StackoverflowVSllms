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

public class FontMetricsParser {
    public static void main(String[] stringArray) {
        try {
            File file = new File("font-metrics.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("font-triplet");
            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);
                if (node.getNodeType() != 1) continue;
                Element element = (Element)node;
                System.out.println("Font Name: " + element.getAttribute("name"));
                System.out.println("Font Style: " + element.getAttribute("style"));
                System.out.println("Font Weight: " + element.getAttribute("weight"));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
