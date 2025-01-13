import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class XPathCompiler {
    XPath xpath = XPathFactory.newInstance().newXPath();
    String expression = "/element1[namespace-uri()='http://example.com/ns1' and local-name()='root']";
    XPathExpression xPathExpression;

    public XPathCompiler() throws Exception {
        xPathExpression = xpath.compile(expression);
    }

    public static void main(String[] args) throws Exception {
        new XPathCompiler();
    }
}