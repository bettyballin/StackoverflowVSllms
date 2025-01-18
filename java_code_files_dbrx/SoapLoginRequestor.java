import java.lang.String;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class SoapLoginRequestor {
    // Assuming 'userName' and 'password' are string variables containing actual username and password values
    private String userName = "your_username";
    private String password = "your_password";

    private void Login() {
        String NAMESPACE = "http://tempuri.org/"; // Namespace should be replaced by appropriate WSDL URL generated with your application
        String METHOD_NAME = "Login";
        String SOAP_ACTION = "http://tempuri.org/" + METHOD_NAME; // Replace the URL properly after checking from WSDL file of application
        
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("username", userName);  
        request.addProperty("password", password);

        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
        soapEnvelope.setOutputSoapObject(request); // Make the request object into SOAP envelope

        HttpTransportSE httpTransport = new HttpTransportSE("http://192.168.1.5:8000/");  // Replace with proper URL to server hosting WCF service
        
        try {
            httpTransport.call(SOAP_ACTION, soapEnvelope);
            Object response = soapEnvelope.getResponse(); // Get appropriate casted response of actual data type instead of generic Object
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // You can invoke the Login method here if needed
    }
}