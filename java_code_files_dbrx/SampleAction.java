public class SampleAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        MyObject obj = new MyObject(); // create or get your object here
        request.setAttribute("obj", obj);  // store the object as a request attribute
        return mapping.findForward("sampleAction");
    }

    public static void main(String[] args) {
    }
}

class Action {
    // Base class placeholder
}

class ActionForward {
    // Placeholder class
}

class ActionMapping {
    public ActionForward findForward(String name) {
        return new ActionForward();
    }
}

class ActionForm {
    // Placeholder class
}

interface HttpServletRequest {
    void setAttribute(String name, Object obj);
}

interface HttpServletResponse {
    // Placeholder interface
}

class MyObject {
    // Placeholder class
}