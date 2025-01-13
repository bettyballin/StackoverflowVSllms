import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XmlValidator {

    public static void main(String[] args) {
        String xmlFile = "path/to/your/xmlfile.xml";
        String dtdFile = "path/to/your/dtdfile.dtd";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(new EntityResolver() {
                @Override
                public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                    // override the DTD location
                    return new InputSource(new FileInputStream(dtdFile));
                }
            });

            builder.parse(new File(xmlFile));
            System.out.println("XML file is valid.");
        } catch (ParserConfigurationException e) {
            System.out.println("Parser configuration error: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("XML file is not valid: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        }
    }
}