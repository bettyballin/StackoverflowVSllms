import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class XPathTest {
    public static void main(String[] args) throws Exception {
        String htmlContent = "<html><head><title>Example</title></head><body>"; // Your HTML content here
        InputSource is = new InputSource(new StringReader(htmlContent));
        boolean hasTags;

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathExpression expr = xpath.compile("boolean(/html/body) and boolean(/html/head/title)"); // Modify this line based on desired tags to check existence of
        hasTags = (Boolean)expr.evaluate(is, XPathConstants.BOOLEAN);

        if (hasTags) {
            System.out.println("The specified tags exist.");
        } else {
            System.out.println("The specified tags do not exist.");
        }
    }
}