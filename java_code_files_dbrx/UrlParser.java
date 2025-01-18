import java.net.URL;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class UrlParser {

    public static void main(String[] args) throws Exception {
        String base_url = "http://example.com/"; // placeholder base URL
        String[] countries = new String[] {"us", "uk", "ca"}; // placeholder country codes
        int c = 0; // index into countries array

        String url_string = base_url + countries[c];
        URL url = new URL(url_string);

        Tidy tidy = new Tidy();
        tidy.setShowWarnings(false);
        tidy.setXHTML(true);
        tidy.setMakeClean(true);
        Document doc = tidy.parseDOM(url.openStream(), null);

        String xpath_string = "id('catlisting')//a";
        XPath xpath = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xpath.compile(xpath_string);

        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("size=" + nodes.getLength());
        for (int r = 0; r < nodes.getLength(); r++) {
            System.out.println(((Element) nodes.item(r)).getTextContent());
        }
    }
}