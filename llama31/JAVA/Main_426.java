import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.SimpleNamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

public class Main_426 {
    public static void main(String[] args) throws Exception {
        // Create a SimpleNamespaceContext instance
        NamespaceContext namespaceContext = new SimpleNamespaceContext();

        // Add namespace mappings
        namespaceContext.bindNamespaceUri("prefix1", "http://example.com/ns1");
        namespaceContext.bindNamespaceUri("prefix2", "http://example.com/ns2");

        // Use the NamespaceContext with your XPath expression
        XPath xpath = XPathFactory.newInstance().newXPath();
        xpath.setNamespaceContext(namespaceContext);
    }
}