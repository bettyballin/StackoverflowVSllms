import java.lang.String;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XmlMarshaller {
    public String marshall(Object object) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }

    public static void main(String[] args) {
    }
}