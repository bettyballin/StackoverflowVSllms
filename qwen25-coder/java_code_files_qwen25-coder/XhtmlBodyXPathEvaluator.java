import java.lang.String;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import javax.xml.namespace.QName;

public class XhtmlBodyXPathEvaluator {
    XPathFactory xpf = XPathFactory.newInstance();
    XPath xpath = xpf.newXPath();
    Document document = null;

    XPathExpression expr;
    Object result;

    public XhtmlBodyXPathEvaluator() throws XPathExpressionException {
        expr = xpath.compile("/child::node()/child::*[local-name()='body' and namespace-uri()='http://www.w3.org/1999/xhtml']");
        result = expr.evaluate(document, XPathConstants.NODESET);
    }

    public static void main(String[] args) {
    }
}