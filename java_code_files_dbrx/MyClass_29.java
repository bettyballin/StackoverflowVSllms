import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class MyClass {

    public static void main(String[] args) throws Exception {

        // create WebService client with a new endpoint URL, QName and SoapFactory
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage message = messageFactory.createMessage();
        SOAPBody body = message.getSOAPBody();
        QName name = new QName("http://yourdomain/example", "someMethod");
        SOAPElement elem_1 = soapBodyElement(body, name);
        // invoke your method
    }

    public static SOAPElement soapBodyElement(SOAPBody body, QName name) throws SOAPException {
        return body.addBodyElement(name);
    }
}