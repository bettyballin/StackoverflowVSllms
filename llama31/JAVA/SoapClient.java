import java.net.URL;
import java.net.HttpURLConnection;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;

public class SoapClient {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://example.com/soap/service");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
    connection.setRequestProperty("SOAPAction", "your_soap_action");
    
    SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
    SOAPPart soapPart = soapMessage.getSOAPPart();
    SOAPEnvelope envelope = soapPart.getEnvelope();
    SOAPBody body = envelope.getBody();
    SOAPElement element = body.addChildElement("your_method", "your_namespace");
    
    // Add method parameters
    SOAPElement param = element.addChildElement("param1");
    param.setTextContent("value1");
    
    soapMessage.writeTo(connection.getOutputStream());
    
    int responseCode = connection.getResponseCode();
    if (responseCode == 200) {
      // Process response
    }
  }
}