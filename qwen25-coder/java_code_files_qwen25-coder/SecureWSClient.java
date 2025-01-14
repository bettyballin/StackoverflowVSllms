import javax.xml.ws.BindingProvider;
import java.util.Map;

public class SecureWSClient {
    private static final char[] PASSWORD = "changeme".toCharArray();

    public void makeSecureCall(ServicePort port) {
        Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
        requestContext.put(BindingProvider.USERNAME_PROPERTY, "foobar");
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, new String(PASSWORD));

        try {
            // Make your web service call here
        } finally {
            clearPasswordArray(PASSWORD);
        }
    }

    private void clearPasswordArray(char[] password) {
        if (password != null) {
            for (int i = 0; i < password.length; i++) {
                password[i] = '\0';
            }
        }
    }

    public static void main(String[] args) {
        // Example usage (assuming you have a ServicePort implementation)
        // SecureWSClient client = new SecureWSClient();
        // ServicePort port = ...;
        // client.makeSecureCall(port);
    }
}

// Placeholder interface to allow compilation
interface ServicePort {
    // Define necessary methods here
}