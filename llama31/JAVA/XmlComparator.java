import java.lang.String;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XmlComparator {

    public static boolean compareXml(String xml1, String xml2) throws Exception {
        Document doc1 = parseXml(xml1);
        Document doc2 = parseXml(xml2);

        return compareElements(doc1.getDocumentElement(), doc2.getDocumentElement());
    }

    private static Document parseXml(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
    }

    private static boolean compareElements(Element element1, Element element2) {
        if (!element1.getTagName().equals(element2.getTagName())) {
            return false;
        }

        if (!element1.getTextContent().equals(element2.getTextContent())) {
            return false;
        }

        NodeList children1 = element1.getChildNodes();
        NodeList children2 = element2.getChildNodes();

        if (children1.getLength() != children2.getLength()) {
            return false;
        }

        for (int i = 0; i < children1.getLength(); i++) {
            Node child1 = children1.item(i);
            Node child2 = children2.item(i);

            if (child1 instanceof Element && child2 instanceof Element) {
                if (!compareElements((Element) child1, (Element) child2)) {
                    return false;
                }
            }
        }

        return true;
    }

	public static void main(String[] args) {
	}
}