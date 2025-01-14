import org.w3c.dom.*;
import javax.xml.xpath.*;
import java.net.URL;
import org.w3c.tidy.Tidy;

public class XPathExample_8 {
    public static void main(String[] args) throws Exception {
        String url_string = "your_base_url_here"; // replace with actual base URL
        URL url = new URL(url_string);

        Tidy tidy = new Tidy();
        tidy.setShowWarnings(false);
        tidy.setXHTML(true);
        tidy.setMakeClean(true);
        Document doc = tidy.parseDOM(url.openStream(), null);

        XPath xpath = XPathFactory.newInstance().newXPath();

        // If the document has a namespace, specify it here
        // Otherwise, you can leave this as is
        String xpath_string = "id('catlisting')//a";
        // Uncomment and modify if namespaces are applicable:
        // xpath.setNamespaceContext(new SimpleNamespaceContext());

        XPathExpression expr = xpath.compile(xpath_string);

        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("size=" + nodes.getLength());
        for (int r = 0; r < nodes.getLength(); r++) {
            Node node = nodes.item(r);
            // Use getTextContent() to fetch the text content of the node
            System.out.println(node.getTextContent().trim());
        }
    }
}

// Uncomment if you need a SimpleNamespaceContext implementation:
// import java.util.Iterator;
// import javax.xml.namespace.NamespaceContext;
//
// class SimpleNamespaceContext implements NamespaceContext {
//     @Override
//     public String getNamespaceURI(String prefix) {
//         // define your namespace URIs here
//         return "";
//     }
//
//     @Override
//     public String getPrefix(String namespaceURI) {
//         throw new UnsupportedOperationException();
//     }
//
//     @Override
//     public Iterator<String> getPrefixes(String namespaceURI) {
//         throw new UnsupportedOperationException();
//     }
// }