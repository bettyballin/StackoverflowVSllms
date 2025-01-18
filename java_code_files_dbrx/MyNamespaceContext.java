import javax.xml.namespace.NamespaceContext;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class MyNamespaceContext implements NamespaceContext {

    @Override
    public String getNamespaceURI(String prefix) {
        return doSomeLookupOfPrefixToNamespaceMap().get(prefix); // implement this method
    }

    @Override
    public String getPrefix(String namespaceURI) {
        if (namespaceURI.isEmpty())
            return ""; // hack to enable using local names as xpaths. This is illegal, but it works for some processors.
        else
            return "ns";  // assume all namespaces have the same alias 'ns'
    }

    @Override
    public Iterator<String> getPrefixes(String namespaceURI) {
        throw new UnsupportedOperationException();
    }

    private Map<String, String> doSomeLookupOfPrefixToNamespaceMap() {
        // Implement this method to return a mapping from prefixes to namespace URIs
        Map<String, String> prefixToNamespaceMap = new HashMap<>();
        // Example mapping; adjust as needed
        prefixToNamespaceMap.put("ns", "http://example.com/namespace");
        return prefixToNamespaceMap;
    }

    public static void main(String[] args) {
        // You can test your MyNamespaceContext here
    }
}