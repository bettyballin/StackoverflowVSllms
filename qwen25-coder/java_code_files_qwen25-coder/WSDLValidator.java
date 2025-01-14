// Example usage of WSDL4J in Java:
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

public class WSDLValidator {
    public static void main(String[] args) {
        try {
            WSDLFactory wsdlFactory = WSDLFactory.newInstance();
            WSDLReader reader = wsdlFactory.newWSDLReader();
            reader.readWSDL("http://example.com/service?wsdl");
            System.out.println("WSDL is valid.");
        } catch (WSDLException e) {
            System.err.println("Error validating WSDL: " + e.getMessage());
        }
    }
}