import java.lang.String;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class SessionManager_1 {

    public static void main(String[] args) {
    }
    
    public void manageSession(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(); // Retrieve session object
        String attributeName = "attribute"; // Attribute name within the session object
        Object attributeValue = ""; // Value to store in the attribute (could be an object)

        httpSession.setAttribute(attributeName, attributeValue); // Store the value into a session
    }
}