import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Schema;
import javax.xml.bind.SchemaFactory;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.XMLConstants;
import java.io.File;

@XmlRootElement(name = "yourClass")
class YourClass {}

public class Main_415 {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(YourClass.class);
        Marshaller marshaller = context.createMarshaller();

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("your_schema.xsd"));

        marshaller.setSchema(schema);

        YourClass yourObject = new YourClass(); // Initialize your object
        marshaller.marshal(yourObject, new File("output.xml"));
    }
}