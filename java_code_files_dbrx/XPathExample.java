import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;

public class XPathExample {
    public static void main(String[] args) throws Exception {
        String xml = "<root>" +
                          "<cert id=\"1\">" +
                              "some content" +
                          "</cert>" +
                          "<cert id=\"2\">" +
                              "some other content" +
                          "</cert>" +
                          "<cert id=\"3\">" +
                              "more content" +
                          "</cert>" +
                      "</root>";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expr = xpath.compile("//cert[@id='2']");
        NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getTextContent());
        }
    }
}