import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

public class JDOM2NamespaceExample {
    public static void main(String[] args) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build("example.xml");

        Namespace ns = Namespace.getNamespace("ns", "http://example.com/namespace");
        XPathFactory xpfac = XPathFactory.instance();

        XPathExpression<Element> expr = xpfac.compile("//ns:elementName",
                Filters.element(), null, ns);

        List<Element> elements = expr.evaluate(document);
    }
}