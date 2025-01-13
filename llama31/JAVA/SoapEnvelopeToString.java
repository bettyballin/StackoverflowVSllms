import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;

public class SoapEnvelopeToString {
    public static String soapEnvelopeToString(SOAPMessage soapMessage) throws Exception {
        SOAPPart soapPart = soapMessage.getSOAPPart();
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new StreamSource(soapPart.getContentAsStream()), new StreamResult(writer));
        return writer.toString();
    }

    public static void main(String[] args) {
    }
}