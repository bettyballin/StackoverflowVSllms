import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class SessionValidator {
    private HttpServletRequest request;

    public SessionValidator(HttpServletRequest request) {
        this.request = request;
    }

    public Boolean checkIfSessionIsValid(String sessionId) {
        HttpSession session = request.getSession();
        return session.getId().equals(sessionId);
    }

    public static void main(String[] args) {
        // You need to get an instance of HttpServletRequest to use this class.
        // For example, in a Servlet, you would do something like this:
        // HttpServletRequest request = ...; // get the request object
        // SessionValidator validator = new SessionValidator(request);
        // validator.checkIfSessionIsValid("someSessionId");
    }
}