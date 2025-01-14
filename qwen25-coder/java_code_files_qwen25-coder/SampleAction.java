import java.util.Set;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String string = "TEST";
        // Set attribute in request scope
        request.setAttribute("sharedString", string);

        return mapping.findForward("sampleAction");
    }

    public static void main(String[] args) {
    }
}