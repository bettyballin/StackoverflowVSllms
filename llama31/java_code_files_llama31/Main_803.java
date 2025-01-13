/*
 * Decompiled with CFR 0.152.
 */
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main_803 {
    public static void main(String[] stringArray) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("timelog.xml");
            NodeList nodeList = document.getElementsByTagName("timecommand");
            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);
                if (node.getNodeType() != 1) continue;
                Element element = (Element)node;
                String string = element.getAttribute("cmd");
                String string2 = element.getAttribute("date");
                String string3 = element.getAttribute("time");
                String string4 = element.getAttribute("proj");
                System.out.println("cmd: " + string + ", date: " + string2 + ", time: " + string3 + ", proj: " + string4);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
