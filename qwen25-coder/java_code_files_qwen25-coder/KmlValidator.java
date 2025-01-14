import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class KmlValidator {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            Document doc = dbFactory.newDocumentBuilder().parse("path/to/yourfile.kml");
            System.out.println("KML File is well-formed!");
        } catch (Exception e) {
            System.err.println("Error parsing KML file: " + e.getMessage());
        }
    }
}