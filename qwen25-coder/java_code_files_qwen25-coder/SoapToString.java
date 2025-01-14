import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class SoapToString {
    public static String soapMessageToString(SOAPMessage message) throws Exception {
        StringWriter sw = new StringWriter();
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.transform(new DOMSource(message.getSOAPPart()), new StreamResult(sw));
        return sw.toString();
    }

    public static void main(String[] args) throws Exception {
        // Create a SOAP message
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapMessage = factory.createMessage();

        // ... (populate your SOAP message)

        // Convert the SOAP message to a String
        String soapMessageStr = soapMessageToString(soapMessage);
        System.out.println("SOAP message as String: \n" + soapMessageStr);
    }
}