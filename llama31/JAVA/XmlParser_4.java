import java.lang.String;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class XmlParser_4 {
    public static void main(String[] args) {
        String xmlString = "<your-xml-string-here>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlString));
            Document doc = builder.parse(is);
            // Now you can use the 'doc' object to traverse the XML
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // Handle the exception
        }
    }
}