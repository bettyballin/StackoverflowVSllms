import java.util.List;
import java.io.IOException;
import org.jdom2.*;
import org.jdom2.xpath.*;

public class Main_228 {
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document =  builder.build("src/main/resources/test.xml");
        Namespace namespace = Namespace.getNamespace("http://www.foo.com");
        // Notice the namespace prefix "ns" -> ns:collection and not just collection
        XPathExpression<Object> query = XPathFactory.instance().compile("//ns:collection/ns:dvd", Filters.element(), null, namespace);
        List<Element> nodes = (List<Element>) query.evaluate(document);
        for (Element node : nodes) {
            System.out.println("\nNode Name='" +  node.getName() + "' and Attribute Value='"
                     + node.getAttributeValue("id")+ '\'');
        }
    }
}