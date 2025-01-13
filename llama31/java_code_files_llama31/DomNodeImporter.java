/*
 * Decompiled with CFR 0.152.
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomNodeImporter {
    public static void main(String[] stringArray) throws ParserConfigurationException {
        NodeList nodeList = null;
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);
                Node node2 = node.cloneNode(true);
                Node node3 = document.importNode(node2, true);
                document.appendChild(node3);
            }
        }
    }
}
