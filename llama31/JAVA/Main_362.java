import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class Main_362 {
    public static void main(String[] args) throws Exception {
        String xml = "<root><a>#...#</a></root>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse(new InputSource(new StringReader(xml)));

        XPathFactory xPathFactory = javax.xml.xpath.XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        XPathExpression expr = xpath.compile("//a[matches(.,'#...#')]");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        System.out.println(result);
    }
}