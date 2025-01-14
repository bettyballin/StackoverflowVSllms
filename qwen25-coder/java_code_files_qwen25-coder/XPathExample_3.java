import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathExample_3 {
    public static void main(String[] args) {
        try {
            // Create a lax DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            factory.setXIncludeAware(false);
            factory.setExpandEntityReferences(false); // PreventXXE, but still not fully strict

            // Create a DocumentBuilder and parse the XML (replace with your XML source)
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("your_xml_file.xml");

            // Create an XPathFactory and XPath
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // Compile the XPATH (replace with your XPATH expression)
            XPathExpression expr = xpath.compile("//your_xpath_expression");

            // Evaluate and print NodeList
            NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nl.getLength(); i++) {
                System.out.println(nl.item(i).getNodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}