/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Main_675 {
    public static void main(String[] stringArray) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("your_xml_file.xml"));
        XPath xPath = XPathFactory.newInstance().newXPath();
        String string = "/Holes/Hole[@id='1']";
        Node node = (Node)xPath.evaluate(string, document, XPathConstants.NODE);
        String string2 = node.getAttributes().getNamedItem("dia").getNodeValue();
        String string3 = node.getAttributes().getNamedItem("depth").getNodeValue();
        System.out.println("Diameter: " + string2);
        System.out.println("Depth: " + string3);
    }
}
