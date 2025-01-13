/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlValidator {
    public static void main(String[] stringArray) {
        String string = "path/to/your/xmlfile.xml";
        final String string2 = "path/to/your/dtdfile.dtd";
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            documentBuilder.setEntityResolver(new EntityResolver(){

                @Override
                public InputSource resolveEntity(String string, String string22) throws SAXException, IOException {
                    return new InputSource(new FileInputStream(string2));
                }
            });
            documentBuilder.parse(new File(string));
            System.out.println("XML file is valid.");
        }
        catch (ParserConfigurationException parserConfigurationException) {
            System.out.println("Parser configuration error: " + parserConfigurationException.getMessage());
        }
        catch (SAXException sAXException) {
            System.out.println("XML file is not valid: " + sAXException.getMessage());
        }
        catch (IOException iOException) {
            System.out.println("Error reading XML file: " + iOException.getMessage());
        }
    }
}
