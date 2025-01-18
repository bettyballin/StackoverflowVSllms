import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class YourActionClass extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        MyObject objVal = new MyObject(); // Assuming you have a valid Object creation here
        session.setAttribute("obj", objVal);
        return mapping.findForward("success"); // Put your Forward name here.
    }
}

class Action {
    // Empty class acting as a placeholder
}

class ActionMapping {
    public ActionForward findForward(String name) {
        return new ActionForward();
    }
}

class ActionForm {
    // Empty class acting as a placeholder
}

class ActionForward {
    // Empty class acting as a placeholder
}

class MyObject {
    // Empty class acting as a placeholder
}