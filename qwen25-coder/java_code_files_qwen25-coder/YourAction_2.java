public class YourAction_2 extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        // Cast the form to your specific form bean
        YourFormBean formBean = (YourFormBean) form;
        
        // Set properties manually if they are not automatically populated
        String field1 = request.getParameter("field1");
        String field2 = request.getParameter("field2");

        formBean.setField1(field1);
        formBean.setField2(field2);

        // Your logic to validate or manipulate the form data

        return mapping.findForward("success");
    }

    public static void main(String[] args) {
        // You can add code here to test your class if needed
    }
}

// Minimal implementations of required classes and interfaces

class Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return null;
    }
}

class ActionForm {
}

class ActionForward {
}

class ActionMapping {
    public ActionForward findForward(String name) {
        return new ActionForward();
    }
}

class YourFormBean extends ActionForm {
    public void setField1(String field1) {
        // Implementation here
    }

    public void setField2(String field2) {
        // Implementation here
    }
}

interface HttpServletRequest {
    String getParameter(String name);
}

interface HttpServletResponse {
}