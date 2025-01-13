import java.lang.String;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Note: You need to have the XPathFormatter class in your classpath
// If it's not available, you'll get a compilation error
import com.example.xpath.formatter.XPathFormatter;

public class XPathFormatterExample {
    public static void main(String[] args) {
        String xpath = "/some/very[@test = 'whatever']/long[@another-test = perhaps/another/long/xpath[@goes='here']]";

        XPathFormatter formatter = new XPathFormatter();
        String formattedXPath = formatter.format(xpath);

        System.out.println(formattedXPath);
    }
}