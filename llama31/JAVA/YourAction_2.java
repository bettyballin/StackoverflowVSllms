import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class YourAction_2_2 extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        // Get the form values
        String fieldValue = request.getParameter("field_name");
        
        // ... rest of the code remains the same
        
        // You need to return an ActionForward
        return mapping.findForward("success");
    }

	public static void main(String[] args) {
	}
}