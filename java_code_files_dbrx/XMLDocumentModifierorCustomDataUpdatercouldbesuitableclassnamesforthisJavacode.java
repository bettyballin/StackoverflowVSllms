import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class XMLDocumentModifierorCustomDataUpdatercouldbesuitableclassnamesforthisJavacode {

    public static void main(String[] args) throws Exception {

        String customData = "<customdata>\n" +
            "    <tag1 />\n" +
            "    <tag2>mfkdslm</tag2>\n" +
            "    <location />\n" +
            "    <tag3 />\n" +
            "</customdata>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!

        Document document = factory.newDocumentBuilder().parse(new InputSource(new StringReader(customData)));

        // Create an XPath object to traverse the XML content
        XPath xpath = XPathFactory.newInstance().newXPath();

        String expression1 = "/customdata/location"; // get the existing location tag, if available
        Node nodeLocation = (Node) xpath.evaluate(expression1, document, XPathConstants.NODE);

        if (nodeLocation == null) {
            String expression2 = "/customdata"; // insert a new location tag at this position otherwise
            Node parent = (Node) xpath.evaluate(expression2, document, XPathConstants.NODE);

            Element element = document.createElement("location");
            element.setTextContent("http://something");
            parent.appendChild(element); // append the new location tag
        } else {
            nodeLocation.setTextContent("http://something"); // modify the existing location tag text content
        }

        // Print the updated XML Document
        StringWriter sw = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(sw);
        transformer.transform(source, result);
        String updatedXMLDocument = sw.toString().replaceFirst(">", ">\n"); // prettify the output
        System.out.println(updatedXMLDocument);
    }

}