import java.lang.String;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.xpath.*;
import java.io.*;

public class DomParserHelper {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(false);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        InputStream inputStream = null; // You need to initialize inputStream appropriately
        Document doc = builder.parse(inputStream);
        inputStream.close();

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathExpression expr = xpath.compile("//FOO_ELEMENT");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            // Get the text content of the element
            System.out.println(node.getTextContent());
        }
    }
}