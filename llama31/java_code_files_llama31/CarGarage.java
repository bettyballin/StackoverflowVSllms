/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CarGarage {
    String make;
    String color;

    public void setMake(String string) {
        this.make = string;
    }

    public void setColor(String string) {
        this.color = string;
    }

    public void DOMparsingMethod(String string) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new ByteArrayInputStream(string.getBytes()));
        NodeList nodeList = document.getElementsByTagName("car");
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            if (node.getNodeType() != 1) continue;
            Element element = (Element)node;
            this.setMake(element.getElementsByTagName("make").item(0).getTextContent());
            this.setColor(element.getElementsByTagName("color").item(0).getTextContent());
        }
    }

    public static void main(String[] stringArray) {
    }
}
