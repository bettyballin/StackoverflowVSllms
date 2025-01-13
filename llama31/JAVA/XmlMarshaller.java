import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlMarshaller {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(SomeRootElement.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "urn:my:ns1");

        marshaller.startDocument("urn:my:ns1", "someRootElement");
        marshaller.startElement("urn:my:ns1", "someElement");
        // ...
        marshaller.endElement("urn:my:ns1", "someElement");
        // ...
        marshaller.endDocument();
    }
}