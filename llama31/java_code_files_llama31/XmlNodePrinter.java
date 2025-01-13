/*
 * Decompiled with CFR 0.152.
 */
import org.w3c.dom.NodeList;

public class XmlNodePrinter {
    public static void printNodeList(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); ++i) {
            System.out.println(nodeList.item(i).getTextContent());
        }
    }

    public static void main(String[] stringArray) {
    }
}
