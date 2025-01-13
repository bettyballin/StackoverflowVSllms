import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;

public class XPathExample_3 {
    public static void main(String[] args) throws Exception {
        // Load the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = factory.newDocumentBuilder().parse(new File("yourfile.xml"));

        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList) xpath.evaluate("//div[@class='example']", document, XPathConstants.NODESET);

        // Example: print the length of the NodeList
        System.out.println("Number of nodes: " + nodes.getLength());
    }
}