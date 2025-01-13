import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class CarGarage {
    String make, color;

    public void setMake(String make) {
        this.make = make;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void DOMparsingMethod(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new java.io.ByteArrayInputStream(xmlString.getBytes()));

        NodeList nodeList = document.getElementsByTagName("car");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                setMake(element.getElementsByTagName("make").item(0).getTextContent());
                setColor(element.getElementsByTagName("color").item(0).getTextContent());
                // You can add more logic here to handle the extracted values
            }
        }
    }

	public static void main(String[] args) {
	}
}