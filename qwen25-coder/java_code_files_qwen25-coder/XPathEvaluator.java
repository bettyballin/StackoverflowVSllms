import java.lang.String;
import java.lang.Set;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.namespace.NamespaceContext;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.util.Iterator;

public class XPathEvaluator {
    public static void main(String[] args) throws Exception {
        // Initialize document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Let's assume we're parsing a file called "input.xml"
        Document document = builder.parse(new File("input.xml"));
        
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        // Set up the default namespace context
        xpath.setNamespaceContext(new MyNamespaceContext());

        Boolean result = (Boolean) xpath.evaluate("//xhtml:body", document, XPathConstants.BOOLEAN);
    }

    // Define MyNamespaceContext
    public static class MyNamespaceContext implements NamespaceContext {
        @Override
        public String getNamespaceURI(String prefix) {
            if ("xhtml".equals(prefix)) {
                return "http://www.w3.org/1999/xhtml";
            }
            return null;
        }
        @Override
        public String getPrefix(String namespaceURI) {
            return null;
        }
        @Override
        public Iterator getPrefixes(String namespaceURI) {
            return null;
        }
    }
}