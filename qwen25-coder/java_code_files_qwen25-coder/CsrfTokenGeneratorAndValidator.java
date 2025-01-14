import java.lang.String;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CsrfTokenGeneratorAndValidator {
    // Generating and embedding token into URL
    Session session = new Session();
    String csrfToken = generateCsrfToken(session);
    String actionUrl = "/performAction?csrfToken=" + URLEncoder.encode(csrfToken, StandardCharsets.UTF_8.toString());

    // Method to generate CSRF Token
    public String generateCsrfToken(Session session) {
        // Placeholder for token generation logic
        String token = "sampleToken"; // For example purposes
        session.setAttribute("CSRF_TOKEN", token);
        return token;
    }

    // On server-side, validate the token
    public boolean isRequestValid(Request request) {
        String submittedToken = request.getParameter("csrfToken");
        return submittedToken != null && submittedToken.equals(request.getSession().getAttribute("CSRF_TOKEN"));
    }

    public static void main(String[] args) throws Exception {
        CsrfTokenGeneratorAndValidator obj = new CsrfTokenGeneratorAndValidator();
    }
}

class Session {
    public void setAttribute(String key, Object value) {
        // Placeholder method for setting a session attribute
    }

    public Object getAttribute(String key) {
        // Placeholder method for getting a session attribute
        return null;
    }
}

class Request {
    public String getParameter(String name) {
        // Placeholder method for getting a request parameter
        return null;
    }

    public Session getSession() {
        // Placeholder method for getting a session from a request
        return new Session();
    }
}