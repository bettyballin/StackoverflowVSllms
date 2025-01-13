import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import java.io.FileInputStream;
import java.io.IOException;

public class Main_815 {
    public static void main(String[] args) {
        try {
            DOMParser parser = new DOMParser();
            parser.parse(new InputSource(new FileInputStream("input.xml")));
            Document doc = parser.getDocument();
            // Process the parsed document
        } catch (SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}