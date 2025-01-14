import java.lang.String;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import javax.xml.transform.stream.StreamSource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.InputSource;

public class XPathWithRegEx {
    public static void main(String[] args) throws Exception {
        String xml = "<tree><nodea><nodeb>A=foo;B=bar;C=goo;</nodeb></nodea></tree>";
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xml)));

        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "//nodea/nodeb";
        NodeList nodes = (NodeList) xpath.evaluate(expression, document, XPathConstants.NODESET);
        
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            String value = node.getNodeValue();
            
            // If the node value is null, get text content
            if (value == null) {
                value = node.getTextContent();
            }

            Pattern pattern = Pattern.compile("B=(.*?);");
            Matcher matcher = pattern.matcher(value);

            if (matcher.find()) {
                String bValue = matcher.group(1);
                System.out.println("Extracted B value: " + bValue);
            }
        }
    }
}