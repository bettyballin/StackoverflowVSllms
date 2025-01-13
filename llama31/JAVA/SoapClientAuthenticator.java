import java.util.Arrays;
import java.util.Map;

import javax.xml.ws.BindingProvider;

public class SoapClientAuthenticator {
    public static void main(String[] args) {
        // Create an instance of the class
        SoapClientAuthenticator authenticator = new SoapClientAuthenticator();
        // Call the method to perform the SOAP call
        authenticator.makeSoapCall();
    }

    public void makeSoapCall() {
        // Assuming 'port' is a valid BindingProvider instance
        BindingProvider port = // Initialize the port here

        Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
        char[] password = "changeme".toCharArray();
        requestContext.put(BindingProvider.USERNAME_PROPERTY, "foobar");
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, password);

        // Make the SOAP call...

        // Clear the password from memory
        Arrays.fill(password, '0');
    }
}