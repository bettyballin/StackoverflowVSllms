import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.ByteArrayInputStream;

public class CarGarage {
    String make, color;

    public void setValues(String xmlStr) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlStr.getBytes())) {
            Document doc = dbf.newDocumentBuilder().parse(inputStream);
            NodeList nodeList = doc.getElementsByTagName("car"); // get list of all "car" elements
            for (int i = 0; i < nodeList.getLength(); ++i) {    // iterate over car elements
                Element elem = (Element) nodeList.item(i);       // Get a single car element as an instance of Element
                // ... process the data in that "car" here...
            }
        } catch (Exception e) {
            throw new Exception("Unable to parse XML and extract values", e);
        }
    }
    // .... other code ....
}