import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.*;

public class XPathExample_2 {
    public static void main(String[] args) {
        try {
            String xml = "<Obj><Name><![CDATA[SomeText]]></Name></Obj>";
            
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new java.io.ByteArrayInputStream(xml.getBytes("UTF-8")));
            
            XPath xpath = XPathFactory.newInstance().newXPath();
            Node node = (Node) xpath.evaluate("/Obj/Name/text()", doc, javax.xml.xpath.XPathConstants.NODE);
            
            if (node != null) {
                System.out.println(node.getNodeValue());
            } else {
                System.out.println("No node found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}