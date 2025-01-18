import java.lang.String;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;

public class SoapEnvelopeToString_1 {
    public static void main(String[] args) throws Exception {
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "  <soapenv:Body> "+
                "      <someTag>"+
                "          <!-- some data --> "+
                "     </someTag>\n"+
                "</soapenv:Body> "+
                " </soapenv:Envelope>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        ByteArrayInputStream input = new ByteArrayInputStream(xml.getBytes());
        Document doc = builder.parse(input);

        Node root = doc.getFirstChild();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        DOMSource source = new DOMSource(root);
        transformer.transform(source, result);
        System.out.println("SOAP Envelope as string: " + writer.toString());
    }
}