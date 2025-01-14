import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import java.util.HashMap;
import java.util.Map;

public class SimpleNamespaceContext implements NamespaceContext {
    private final Map<String, String> prefixToUri = new HashMap<>();

    public void bindNamespaceURI(String prefix, String uri) {
        this.prefixToUri.put(prefix, uri);
    }

    @Override
    public String getNamespaceURI(String prefix) {
        return this.prefixToUri.getOrDefault(prefix, XMLConstants.NULL_NS_URI);
    }

    @Override
    public String getPrefix(String namespaceURI) {
        for (Map.Entry<String, String> entry : prefixToUri.entrySet()) {
            if (entry.getValue().equals(namespaceURI)) {
                return entry.getKey();
            }
        }
        return XMLConstants.DEFAULT_NS_PREFIX;
    }

    @Override
    public java.util.Iterator<String> getPrefixes(String namespaceURI) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public static void main(String[] args) {
    }
}