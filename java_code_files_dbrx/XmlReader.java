import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import java.io.File;

public class XmlReader {
  public static void main(String[] args) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // Allow external DTDs for validation (true), or not (false).
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

    DocumentBuilder builder = factory.newDocumentBuilder();
    File xmlFile = new File("<PATH_TO_YOUR_FILE>/yourfile.xml");   // replace with your file path, .xml
    Document document = builder.parse(xmlFile);

    XPathFactory xpathFactory = XPathFactory.newInstance();
    XPath xpath = xpathFactory.newXPath();
    String expression = "/root/element[@attribute='value']"; // replace with actual path, @attribute and 'values' as needed

    XPathExpression compiledExpression = xpath.compile(expression);
    NodeList nodes = (NodeList) compiledExpression.evaluate(document, XPathConstants.NODESET);

    for (int i = 0; i < nodes.getLength(); i++) {
      System.out.println("Found: " + nodes.item(i).getNodeValue()); // print found value. Adapt as needed.
    }
  }
}