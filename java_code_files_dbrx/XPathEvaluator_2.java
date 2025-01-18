import java.lang.String;
import javax.xml.xpath.*;

public class XPathEvaluator_2 {
    String myQuery = "/path/to/element"; // replace with your actual query
    XPath navigator = XPathFactory.newInstance().newXPath();
    XPathExpression expr;

    public XPathEvaluator_2() throws XPathExpressionException {
        expr = navigator.compile(myQuery);
    }

    public static void main(String[] args) throws XPathExpressionException {
    }
}