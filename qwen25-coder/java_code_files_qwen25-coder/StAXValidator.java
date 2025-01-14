import java.lang.String;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class StAXValidator {
    public static void main(String[] args) throws Exception {
        File xmlFile = new File("path/to/your/largefile.xml");
        File xsdFile = new File("path/to/your/schema.xsd");

        SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(xsdFile);

        XMLStreamReader xmlStreamReader = null;
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StreamSource(xmlFile));
            schema.newValidator().validate(new javax.xml.transform.stax.StAXSource(xmlStreamReader));
            System.out.println("The document is valid.");
        } catch (Exception e) {
            System.err.println("Document not valid: " + e.getMessage());
        } finally {
            if (xmlStreamReader != null) {
                xmlStreamReader.close();
            }
        }
    }
}