import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class XPathExample_4 {
    public static void main(String[] args) throws Exception {
        String xmlString = "<ArrayOfAnyType xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                           "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://tempuri.org/\">" +
                           "<anyType xsi:type=\"Document\"><Id>5</Id><Title>T1</Title></anyType>" +
                           "<anyType xsi:type=\"Document\"><Id>15</Id><Title>T15</Title></anyType>" +
                           "</ArrayOfAnyType>";

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xmlString.getBytes()));

        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        // Define the namespace context
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.bindNamespaceUri("ns", "http://tempuri.org/");
        nsContext.bindNamespaceUri("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        xpath.setNamespaceContext(nsContext);

        XPathExpression expr = xpath.compile("//ns:anyType[@xsi:type='Document']");
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nodes.getLength(); i++) {
            Element anyTypeElem = (Element) nodes.item(i);
            NodeList idNodes = anyTypeElem.getElementsByTagNameNS("http://tempuri.org/", "Id");
            if (idNodes.getLength() > 0) {
                Node idNode = idNodes.item(0);
                System.out.println(idNode.getTextContent());
            }
        }
    }
}

class SimpleNamespaceContext implements NamespaceContext {
    private final Map<String, String> namespaceMap = new HashMap<>();

    public void bindNamespaceUri(String prefix, String namespaceUri) {
        namespaceMap.put(prefix, namespaceUri);
    }

    @Override
    public String getNamespaceURI(String prefix) {
        if (prefix == null) throw new NullPointerException("Null prefix");
        String uri = namespaceMap.get(prefix);
        return uri != null ? uri : XMLConstants.NULL_NS_URI;
    }

    @Override
    public String getPrefix(String namespaceUri) {
        for (Map.Entry<String, String> entry : namespaceMap.entrySet()) {
            if (entry.getValue().equals(namespaceUri)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public Iterator<String> getPrefixes(String namespaceUri) {
        return namespaceMap.keySet().iterator();
    }
}