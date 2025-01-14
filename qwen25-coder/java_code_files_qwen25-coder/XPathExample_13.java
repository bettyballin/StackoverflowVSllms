import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XPathExample_13 {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true); // important!
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse("your-document.xml");

        XPath xpath = XPathFactory.newInstance().newXPath();
        
        // Register the namespace prefix (e.g., 'xhtml' for XHTML)
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.bindNamespaceUri("xhtml", "http://www.w3.org/1999/xhtml");
        xpath.setNamespaceContext(nsContext);

        // XPath to select the topmost element considering XHTML namespace or a custom namespace
        String xPathExpression = "/*[self::xhtml:body | self::*[@xmlns]]";
        
        XPathExpression expr = xpath.compile(xPathExpression);
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);

        if (node != null) {
            System.out.println("Selected Node: " + node.getNodeName());
        } else {
            System.out.println("No node selected.");
        }
    }
}

class SimpleNamespaceContext implements NamespaceContext {
    private Map<String, String> prefixToUri = new HashMap<>();

    public void bindNamespaceUri(String prefix, String uri) {
        prefixToUri.put(prefix, uri);
    }

    @Override
    public String getNamespaceURI(String prefix) {
        return prefixToUri.get(prefix);
    }

    @Override
    public String getPrefix(String namespaceURI) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<String> getPrefixes(String val) {
        throw new UnsupportedOperationException();
    }
}