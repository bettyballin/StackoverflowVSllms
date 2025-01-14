import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import java.io.StringReader;
import org.xml.sax.InputSource;

public class Main {
    public static void main(String[] args) {
        // Load your XML into a Document object
        String xml = "<root>\n" +
                "    <childNode>\n" +
                "        <grandChildNode attrib1=\"value1\" attrib2=\"value2\">Text1</grandChildNode>\n" +
                "        <grandChildNode attrib1=\"value3\" attrib2=\"value4\">Text2</grandChildNode>\n" +
                "    </childNode>\n" +
                "</root>";

        // Parse the XML String into a Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // Enable namespaces for XPath
        DocumentBuilder builder;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // XPath expression to get all grandChildNodes
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        String xpathExpression = "//grandChildNode";

        try {
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                System.out.println("attrib1: " + element.getAttribute("attrib1"));
                System.out.println("attrib2: " + element.getAttribute("attrib2"));
                System.out.println("Text: " + element.getTextContent());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}