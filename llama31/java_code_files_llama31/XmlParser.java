/*
 * Decompiled with CFR 0.152.
 */
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParser {
    public static void main(String[] stringArray) {
        NodeList nodeList = null;
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node;
                Node node2 = nodeList.item(i);
                if (node2.getNodeType() != 1 || (node = node2.getFirstChild()) == null || node.getNodeType() != 3) continue;
                System.out.println(node.getNodeValue());
            }
        }
    }
}
