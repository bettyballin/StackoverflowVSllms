import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;

public class NamespaceContextImpl implements NamespaceContext {
    // add a Default Namespace if no prefix used in the source xml e.g.,
    public String getNamespaceURI(String prefix) {
        if (prefix.equals(""))
            return "default-namespace";
        else
            throw new IllegalArgumentException("No namespace for " + prefix);
    }

    public Iterator<String> getPrefixes(String namespaceURI) {
        ArrayList<String> prefixes = new ArrayList<String>();
        if ("default-namespace".equals(namespaceURI))
            prefixes.add(""); // add empty String in case of default namespace
        return prefixes.iterator();
    }

    public String getPrefix(String namespaceURI) {
        throw new IllegalArgumentException("No prefix for " + namespaceURI);
    }

    public static void main(String[] args) {
        // Example usage
        NamespaceContextImpl nsContext = new NamespaceContextImpl();
        String nsURI = nsContext.getNamespaceURI("");
        System.out.println("Namespace URI for empty prefix: " + nsURI);
    }
}