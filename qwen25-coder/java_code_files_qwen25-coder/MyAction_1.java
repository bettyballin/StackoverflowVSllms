import java.lang.String;

public class MyAction_1 extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        // Your object to store in session
        MyObject objval = new MyObject();
        
        // Get the current HTTP Session
        HttpSession session = request.getSession();
        
        // Store your object in session scope
        session.setAttribute("obj", objval);
        
        // Proceed with other logic...
        
        return mapping.findForward("success");
    }

    public static void main(String[] args) {
    }
}

// Minimal stub classes and interfaces to make the code compile
class MyObject {
    // Your object's implementation
}

class Action {
    // Minimal implementation to extend
}

class ActionForward {
    // Minimal implementation
}

class ActionMapping {
    public ActionForward findForward(String name) {
        return new ActionForward();
    }
}

class ActionForm {
    // Minimal implementation
}

interface HttpServletRequest {
    HttpSession getSession();
}

interface HttpServletResponse {
    // Minimal implementation
}

interface HttpSession {
    void setAttribute(String name, Object value);
}