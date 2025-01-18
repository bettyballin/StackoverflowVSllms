import java.io.*;
import java.net.*;
import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

public class Main {
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class); // where your ObjectFactory is the one generated from XSD schemas
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        URL schemaFile = new File("sample.xsd").toURI().toURL(); // or any other way to get your xsd file as URL
        Source schemaDocument = new StreamSource(schemaFile.openStream());
        Schema s = sf.newSchema(schemaDocument);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(s);
        InputStream source = new FileInputStream("sample.xml"); // where source is an XML InputStream you are trying to validate and marshal back
        JAXBElement<?> elt = (JAXBElement<?>) unmarshaller.unmarshal(source);
        // Validate if necessary:
        StringWriter xmlOut = new StringWriter();
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  // add a new line or not
        m.marshal(elt, xmlOut); // This will throw an exception if there is an issue with validation.

        // Optional: print the output
        System.out.println(xmlOut.toString());
    }
}

// Minimal ObjectFactory class to allow compilation
class ObjectFactory {
    // You can add any necessary code here
}