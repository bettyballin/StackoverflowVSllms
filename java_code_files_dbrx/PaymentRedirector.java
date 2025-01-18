import java.lang.String;
public class PaymentRedirector {
    public static void main(String[] args) {
        Session session = new Session();
        String paymentGatewayUrl = "http://example.com/payment";
        Response response = new Response();

        session.setAttribute("attribute_key", "attribute value"); // set / refresh session attribute at your application side
        // then perform redirection or request for payment page here...
        response.sendRedirect(paymentGatewayUrl);
    }
}

class Session {
    public void setAttribute(String key, String value) {
        System.out.println("Setting session attribute: " + key + " = " + value);
    }
}

class Response {
    public void sendRedirect(String url) {
        System.out.println("Redirecting to: " + url);
    }
}