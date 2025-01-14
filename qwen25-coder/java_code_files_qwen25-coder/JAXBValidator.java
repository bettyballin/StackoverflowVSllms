import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class JAXBValidator {
    public static void main(String[] args) throws Exception {
        // Create a JAXB context for your classes
        JAXBContext jc = JAXBContext.newInstance(MyClass.class);

        // Create a Marshaller instance to convert Java objects into XML 
        Marshaller marshaller = jc.createMarshaller();
        
        // Enable schema validation in the context of marshalling
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File xsdFile = new File("path/to/your/schema.xsd");
        Schema schema = factory.newSchema(xsdFile);

        marshaller.setSchema(schema);
        
        // Optionally format the output to be more readable (this is not needed for validation, but useful for checking)
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        MyClass myClassObject = new MyClass();
        // ... populate your object properties ...

        // Marshalling with schema validation
        marshaller.marshal(myClassObject, System.out);  // This will output XML to console, but it can be a file or any other stream.
    }
}

@XmlRootElement
class MyClass {
    // ... properties and methods ...
}