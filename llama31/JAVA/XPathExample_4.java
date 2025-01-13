import java.io.File;
import java.lang.String;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPath;

public class XPathExample_4_4 {
    public static void main(String args[]) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document d = builder.build(new File("xpath.xml"));
        XPath xpath = XPath.newInstance("/ns:collection/ns:dvd");
        xpath.addNamespace("ns", d.getRootElement().getNamespaceURI());
        System.out.println(xpath.selectNodes(d));
    }
}