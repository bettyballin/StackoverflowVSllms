import java.util.UUID;
import java.lang.StringBuilder;

public class CSRFTokenGenerator {

    public static void main(String[] args) {
        // Create instances of session, request, response
        HttpSession session = new HttpSession();
        HttpServletRequest request = new HttpServletRequest();
        HttpServletResponse response = new HttpServletResponse();
        
        // On the server side, generate and send a token in hidden form fields
        String csrfToken = UUID.randomUUID().toString();
        session.setAttribute("csrfToken", csrfToken);
        
        // Generate HTML form including the CSRF token
        StringBuilder htmlForm = new StringBuilder()
            .append("<form action=\"/performAction\" method=\"post\">")
            .append("<input type=\"hidden\" name=\"csrfToken\" value=\"").append(csrfToken).append("\">")
            .append("...")
            .append("</form>");

        System.out.println("Generated HTML Form:\n" + htmlForm.toString());

        // Simulate sending the form to the client and receiving the request back
        // For simplicity, we assume the csrfToken is sent back correctly
        request.setParameter("csrfToken", csrfToken);

        // On the server side, validate the token before processing the request
        String requestCsrfToken = request.getParameter("csrfToken");
        if (!requestCsrfToken.equals(session.getAttribute("csrfToken"))) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF Token");
        } else {
            System.out.println("CSRF Token is valid. Proceed with the request.");
        }
    }
}

// Minimal implementation of HttpSession
class HttpSession {
    private java.util.Map<String, Object> attributes = new java.util.HashMap<>();
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }
    public Object getAttribute(String name) {
        return attributes.get(name);
    }
}

// Minimal implementation of HttpServletRequest
class HttpServletRequest {
    private java.util.Map<String, String> parameters = new java.util.HashMap<>();
    public void setParameter(String name, String value) {
        parameters.put(name, value);
    }
    public String getParameter(String name) {
        return parameters.get(name);
    }
}

// Minimal implementation of HttpServletResponse
class HttpServletResponse {
    public static final int SC_FORBIDDEN = 403;
    public void sendError(int statusCode, String message) {
        System.out.println("Error " + statusCode + ": " + message);
    }
}