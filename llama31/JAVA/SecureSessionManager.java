import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SecureSessionManager {
    public void processRequest(HttpServletRequest request, HttpSession session) {
        // Assume 'sensitiveData' is a sensitive information
        String sensitiveData = request.getParameter("sensitiveData");

        // Store sensitive data on the server-side
        session.setAttribute("sensitiveData", sensitiveData);

        // Use the stored sensitive data for further processing
        String storedData = (String) session.getAttribute("sensitiveData");
    }

    public static void main(String[] args) {
        // This main method is empty because this class is designed to be used in a web application,
        // where the processRequest method would be called from a servlet or other web component.
    }
}