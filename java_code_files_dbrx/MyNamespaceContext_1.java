import javax.xml.namespace.NamespaceContext;
import javax.xml.XMLConstants;
import java.util.Iterator;
import java.util.Collections;

class MyNamespaceContext implements NamespaceContext {
    @Override
    public String getNamespaceURI(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("No prefix provided!");
        } else if ("xhtml".equals(prefix)) {
            return "http://www.w3.org/1999/xhtml";
        } else {
            return XMLConstants.NULL_NS_URI; // default namespace URI
        }
    }

    @Override
    public String getPrefix(String namespaceURI) {
        if ("http://www.w3.org/1999/xhtml".equals(namespaceURI)) {
            return "xhtml";
        } else {
            return null;
        }
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
        if ("http://www.w3.org/1999/xhtml".equals(namespaceURI)) {
            return Collections.singleton("xhtml").iterator();
        } else {
            return Collections.emptyIterator();
        }
    }
}