import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.StringReader;

@XmlRootElement(name = "root")
public class Response {
    private String fieldName;

    public String getFieldName() {
        return fieldName;
    }

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Response.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        String webResponse = "<root><fieldName>example</fieldName></root>"; // example web response
        Response response = (Response) unmarshaller.unmarshal(new StringReader(webResponse));

        String webServicesValue = response.getFieldName();
        System.out.println(webServicesValue);
    }
}