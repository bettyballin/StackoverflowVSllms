import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class SessionManager_6_6 {
    public static void main(String[] args) {
        // This code should be inside a servlet or a method that has access to HttpServletRequest and HttpSession
        // Here we are just simulating the environment for compilation purposes
        HttpServletRequest request = null; // This should be obtained from a servlet or a method that has access to HttpServletRequest
        HttpSession session = request.getSession();
        String yourCustomId = null; // Replace with your actual custom ID
        session.setAttribute("customId", yourCustomId);
    }
}