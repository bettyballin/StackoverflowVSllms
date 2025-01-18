import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import java.io.StringReader;
import javax.xml.namespace.NamespaceContext;
import java.util.Iterator;

public class Main_60 {
    public static void main(String[] args) throws Exception {
        String xml = "<myXml xmlns:fn='http://www.w3.org/2005/xpath-functions'><data>Hello World</data></myXml>";
        InputSource inputSource = new InputSource(new StringReader(xml));

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        NamespaceContext nsContext = new NamespaceContext() {
            @Override
            public String getNamespaceURI(String prefix) {
                if (prefix == null) throw new NullPointerException("Null prefix");
                else if ("fn".equals(prefix)) return "http://www.w3.org/2005/xpath-functions";
                return null;
            }
            @Override
            public String getPrefix(String namespaceURI) {
                throw new UnsupportedOperationException();
            }
            @Override
            public Iterator<String> getPrefixes(String namespaceURI) {
                throw new UnsupportedOperationException();
            }
        };
        xpath.setNamespaceContext(nsContext);

        XPathExpression expr = xpath.compile("fn:ends-with(/myXml/data, 'World')");
        Boolean result = (Boolean)expr.evaluate(inputSource, XPathConstants.BOOLEAN);
    }
}