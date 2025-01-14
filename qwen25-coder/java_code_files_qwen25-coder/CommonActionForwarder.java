public class CommonActionForwarder {
    public ActionForward execute(ActionMapping mapping, MyActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String data = "Common Data";
        form.setSharedData(data);

        // Optionally set additional request attributes if needed
        Object someOtherObject = new Object(); // declare someOtherObject
        request.setAttribute("anotherAttribute", someOtherObject);

        return mapping.findForward("commonJsp");
    }

    public static void main(String[] args) {
        // Entry point
    }
}

class ActionForward {
    // Dummy class
}

class ActionMapping {
    public ActionForward findForward(String name) {
        return new ActionForward(); // Dummy implementation
    }
}

class MyActionForm {
    public void setSharedData(String data) {
        // Dummy implementation
    }
}

interface HttpServletRequest {
    void setAttribute(String name, Object value);
}

interface HttpServletResponse {
    // Empty interface
}