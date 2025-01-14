import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import java.util.List;

public class XPathExample_5 {
    public static void main(String[] args) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document d = builder.build("xpath.xml");
        
        // Create a namespace with a prefix that matches your XML
        String defaultNamespaceUri = "http://www.foo.com";
        String prefix = "ns";  // You can choose any non-empty string as prefix

        // Register the namespace in the XPathFactory instance
        XPathFactory xpfac = XPathFactory.instance();
        XPathExpression<Element> expr = xpfac.compile(
                "/ns:collection/ns:dvd",
                Filters.element(),
                null,
                Namespace.getNamespace(prefix, defaultNamespaceUri)
        );

        List<Element> dvds = expr.evaluate(d);
        System.out.println(dvds);
    }
}