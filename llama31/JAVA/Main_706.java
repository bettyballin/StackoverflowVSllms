import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import org.xml.sax.InputSource;

public class Main_706 {
    public static void main(String[] args) throws Exception {
        String xml = "<tree><nodea><nodeb>A=foo;B=bar;C=goo;</nodeb></nodea></tree>";
        XPath xpath = XPathFactory.newInstance().newXPath();
        String result = (String) xpath.evaluate("//nodea/nodeb/replace(., '.*B=(.*?)\\;.*', '$1')", new InputSource(new StringReader(xml)), XPathConstants.STRING);
        System.out.println(result); // Output: bar
    }
}