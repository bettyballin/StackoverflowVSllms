/*
 * Decompiled with CFR 0.152.
 */
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlComparator {
    public static boolean compareXml(String string, String string2) throws Exception {
        Document document = XmlComparator.parseXml(string);
        Document document2 = XmlComparator.parseXml(string2);
        return XmlComparator.compareElements(document.getDocumentElement(), document2.getDocumentElement());
    }

    private static Document parseXml(String string) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        return documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(string)));
    }

    private static boolean compareElements(Element element, Element element2) {
        if (!element.getTagName().equals(element2.getTagName())) {
            return false;
        }
        if (!element.getTextContent().equals(element2.getTextContent())) {
            return false;
        }
        NodeList nodeList = element.getChildNodes();
        NodeList nodeList2 = element2.getChildNodes();
        if (nodeList.getLength() != nodeList2.getLength()) {
            return false;
        }
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            Node node2 = nodeList2.item(i);
            if (!(node instanceof Element) || !(node2 instanceof Element) || XmlComparator.compareElements((Element)node, (Element)node2)) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] stringArray) {
    }
}
