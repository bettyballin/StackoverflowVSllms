import java.lang.String;
import org.w3c.dom.NodeList;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class TrListParser {
    XPath xpath = XPathFactory.newInstance().newXPath();
    NodeList ABlist = null;
    NodeList trList;

    {
        // Instance initialization block
        try {
            trList = (NodeList) xpath.evaluate(".//table/tbody/tr", ABlist.item(0), XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}