import javax.xml.xpath.*;
import javax.xml.namespace.NamespaceContext;
import javax.xml.XMLConstants;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        MyNamespaceContext context = new MyNamespaceContext();
        xpath.setNamespaceContext(context);
        // now use namespaces in your paths using "ns" prefix, e.g:
        String pathStr = "/ns:root/ns:child"; // this is equivalent to the longer form /{namespace_uri}root/{namespace_uri}child", and it should work no matter what namespace URI you are dealing with, as long as MyNamespaceContext resolves "ns" correctly.
    }

    static class MyNamespaceContext implements NamespaceContext {
        private Map<String, String> prefixMap;

        public MyNamespaceContext() {
            prefixMap = new HashMap<String, String>();
            // Add prefix to namespace mapping
            prefixMap.put("ns", "http://example.com/namespace");
            // Add more prefixes and namespaces as needed
        }

        @Override
        public String getNamespaceURI(String prefix) {
            if (prefix == null) throw new NullPointerException("Null prefix");
            else if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
                return XMLConstants.NULL_NS_URI;
            } else {
                String uri = prefixMap.get(prefix);
                return uri != null ? uri : XMLConstants.NULL_NS_URI;
            }
        }

        @Override
        public String getPrefix(String namespaceURI) {
            for (Map.Entry<String, String> entry : prefixMap.entrySet()) {
                if (entry.getValue().equals(namespaceURI)) {
                    return entry.getKey();
                }
            }
            return null;
        }

        @Override
        public Iterator<String> getPrefixes(String namespaceURI) {
            return prefixMap.keySet().iterator();
        }
    }
}