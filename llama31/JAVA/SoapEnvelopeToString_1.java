import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPException;
import javax.xml.soap.MessageFactory;

public class SoapEnvelopeToString_1 {
    public static String soapEnvelopeToString(SOAPMessage soapMessage) {
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            soapMessage.writeTo(out);
            return out.toString("UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SOAPException {
        // Create a new SOAP message object
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapMessage = factory.createMessage();

        // Convert the SOAP message to a string
        String xmlContent = soapEnvelopeToString(soapMessage);

        // Print the XML content
        System.out.println(xmlContent);
    }
}