import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// Placeholder for YourObject
class YourObject {
    // Define your object's properties and methods
}

public class YourAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) {
        
        // Create or retrieve your object
        YourObject objVal = new YourObject();
        
        // Get the HttpSession object
        HttpSession session = request.getSession();
        
        // Set the object in the session scope
        session.setAttribute("obj", objVal);
        
        // Rest of your code...
        return null; // You would typically return an ActionForward here
    }

    public static void main(String[] args) {
        // This main method won't be able to execute the action without a Servlet context
        System.out.println("This is a Struts Action and needs to be executed within a Servlet container.");
    }
}