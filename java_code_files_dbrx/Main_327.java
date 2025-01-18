import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create a new Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document tree = builder.newDocument();

        int desiredDpi = 300; // Set the desired DPI value

        // Retrieve the existing app0JFIF (if it exists) or create a new one otherwise.
        org.w3c.dom.Element jfif = null;
        NodeList nodeList = tree.getElementsByTagName("app0JFIF");
        if (nodeList.getLength() > 0) {
            org.w3c.dom.Element elem = (org.w3c.dom.Element)nodeList.item(0);
            if (!elem.getAttribute("Xdensity").equalsIgnoreCase("0")) // If the value is not already set, use existing app0jfif element.
                jfif = elem;
        }
        if (jfif == null) {
            jfif = tree.createElement("app0JFIF");
            tree.appendChild(jfif);
            // Populate required attributes with default values:
            jfif.setAttribute("APP0JFIFversion", "1.4");       // JPEG File Interchange Format version (required)
            jfif.setAttribute("resUnits", "1");                // Resolution unit ("INCH" or "CENTIMETER") -- required if X/Ydensity are set
        }
        jfif.setAttribute("Xdensity", Integer.toString(desiredDpi));   // Set desired horizontal resolution (integer: dots per inch)
        jfif.setAttribute("Ydensity", Integer.toString(desiredDpi));   // Set desired vertical resolution (integer: dots per inch)
    }
}