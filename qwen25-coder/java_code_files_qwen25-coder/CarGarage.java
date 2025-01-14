import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class CarGarage {
    private String make, color;

    public void setMake(String make) {
        this.make = make;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void DOMparsingMethod(String xmlString) throws Exception {
        // Parse the XML string
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new java.io.ByteArrayInputStream(xmlString.getBytes()));

        // Optional, but recommended: normalize the XML structure
        doc.getDocumentElement().normalize();

        // Get all 'car' elements and process them
        NodeList carNodes = doc.getElementsByTagName("car");
        for (int i = 0; i < carNodes.getLength(); i++) {
            Element carElement = (Element) carNodes.item(i);
            
            // Extract the make and color values
            String make = carElement.getElementsByTagName("make").item(0).getTextContent();
            String color = carElement.getElementsByTagName("color").item(0).getTextContent();

            // Set the values in your class attributes or process them as needed
            setMake(make);
            setColor(color);
            
            System.out.println("Car Make: " + make + ", Color: " + color);
        }
    }

    public static void main(String[] args) {
        String xmlString = "<carGarage><car><make>Chrysler</make><color>Red</color></car><car><make>Musano</make><color>Blue</color></car></carGarage>";
        
        CarGarage carGarage = new CarGarage();
        try {
            carGarage.DOMparsingMethod(xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}