import java.io.InputStream;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.SAXException;

public class XsdSchemaValidator {
    InputStream inputStream = XsdSchemaValidator.class.getResourceAsStream("/path/to/yourSchema.xsd");
    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema;

    public XsdSchemaValidator() {
        try {
            schema = factory.newSchema(new StreamSource(inputStream));
        } catch (SAXException e) {
            e.printStackTrace();
            schema = null;
        }
    }

    public static void main(String[] args) {
    }
}