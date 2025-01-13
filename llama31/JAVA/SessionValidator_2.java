import java.lang.String;
import javax.servlet.http.HttpSession;

public class SessionValidator_2_2 {
    public static void main(String[] args) {
        // Note: The following code should be inside a servlet or a similar context 
        // where HttpSession is available. For demonstration purposes, it's been moved here.
        
        // Also note: The 'request' object is typically obtained from the HttpServletRequest 
        // which is not available in this context. You may need to modify this code 
        // depending on your application architecture.

        try {
            HttpSession session = null; // request.getSession(false); 
                                        // You need an HttpServletRequest object for this.
            if(session != null) {
                session.getAttribute("someAttribute");
            } else {
                System.out.println("Session is null.");
            }
        } catch (Exception e) {
            // session is invalid
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}