import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.File;

public class Main_675 {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("your_xml_file.xml"));

        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "/Holes/Hole[@id='1']";
        Node holeNode = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);

        String dia = holeNode.getAttributes().getNamedItem("dia").getNodeValue();
        String depth = holeNode.getAttributes().getNamedItem("depth").getNodeValue();

        System.out.println("Diameter: " + dia);
        System.out.println("Depth: " + depth);
    }
}