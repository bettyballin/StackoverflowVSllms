import java.lang.String;
import javax.xml.namespace.NamespaceContext;
import java.util.Iterator;

// Implementing custom NamespaceContext to resolve the default namespace
public class MyNamespaceContext implements NamespaceContext {
    @Override
    public String getNamespaceURI(String prefix) {
        if ("xhtml".equals(prefix)) {
            return "http://www.w3.org/1999/xhtml";
        } else if (prefix == null || prefix.length() == 0) { // Default namespace
            return "http://www.w3.org/1999/xhtml";
        }
        return null;
    }

    @Override
    public String getPrefix(String uri) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterator<String> getPrefixes(String val) {
        throw new UnsupportedOperationException("Not implemented");
    }

	public static void main(String[] args) {
	}
}