import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class HtmlParser_1_1 {
    public static void main(String[] args) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("yourfile.html");
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList ABlist = (NodeList) xpath.evaluate(".//ABlist", document, XPathConstants.NODESET);
        NodeList trList = (NodeList) xpath.evaluate(".//table//tr", ABlist.item(0), XPathConstants.NODESET);
    }
}