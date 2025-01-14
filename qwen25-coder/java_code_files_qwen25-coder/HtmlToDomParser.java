import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.ccil.cowan.tagsoup.Parser;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.StringReader;

public class HtmlToDomParser {
    public static void main(String[] args) throws Exception {
        String html = "<html><body><h1>Hello World</h1></body></html>";

        // Set the system property to use TagSoup as the SAX parser
        System.setProperty("javax.xml.parsers.SAXParserFactory", "org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl");

        // Wrap the HTML string in an InputSource object
        InputSource src = new InputSource(new StringReader(html));

        // Use DocumentBuilderFactory to create a DocumentBuilder
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);

        // Create a DocumentBuilder
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();

        // Parse the HTML (as XML) into a DOM Document
        Document dom = builder.parse(src);

        // Now you can use the standard DOM and XPath API on your parsed HTML document
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "//h1";
        NodeList nodeList = (NodeList) xpath.evaluate(expression, dom, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getTextContent());
        }
    }
}