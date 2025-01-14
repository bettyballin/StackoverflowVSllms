import java.util.List;
import java.util.ArrayList;

public class YourAction_1 extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ServiceForm serviceForm = (ServiceForm) form;
        List<SrvDO> allSrv = serviceForm.getAllSrv();

        // Process the list of SrvDO objects
        for (SrvDO srv : allSrv) {
            System.out.println("nbDays: " + srv.getNbDays()); // or whatever processing you need
        }

        // Return an appropriate action forward
        return mapping.findForward("success");
    }

    public static void main(String[] args) throws Exception {
        YourAction_1 action = new YourAction_1();

        // Create dummy objects for the parameters
        ActionMapping mapping = new ActionMapping();
        ServiceForm form = new ServiceForm();
        HttpServletRequest request = new HttpServletRequest();
        HttpServletResponse response = new HttpServletResponse();

        action.execute(mapping, form, request, response);
    }
}

// Dummy class definitions to make the code executable
class Action {
    // Empty class
}

class ActionForward {
    // Empty class
}

class ActionMapping {
    public ActionForward findForward(String name) {
        return new ActionForward();
    }
}

class ActionForm {
    // Empty class
}

class ServiceForm extends ActionForm {
    public List<SrvDO> getAllSrv() {
        List<SrvDO> list = new ArrayList<>();
        list.add(new SrvDO());
        return list;
    }
}

class SrvDO {
    public int getNbDays() {
        return 5;
    }
}

class HttpServletRequest {
    // Empty class
}

class HttpServletResponse {
    // Empty class
}