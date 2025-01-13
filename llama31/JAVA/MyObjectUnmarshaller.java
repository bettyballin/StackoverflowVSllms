import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.sun.xml.bind.api.JAXBRIContext;
import com.sun.xml.bind.api.UnmarshallerProperties;

public class MyObjectUnmarshaller {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(MyObject.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setProperty(UnmarshallerProperties.DOM_HANDLER_CLASS, MyChildObjectDomHandler.class.getName());
    }
}