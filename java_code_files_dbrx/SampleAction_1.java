import java.lang.String;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleAction_1 extends DispatchAction {
    public ActionForward sampleMethod(ActionMapping mapping, DynaActionForm dyna, HttpServletRequest request, HttpServletResponse response) throws Exception {
        dyna.set("property", "my value"); // Setting the form property here can make it accessible in JSP as `${form name}.${property}` or just using ${property} if not naming a form
        return super.execute(mapping, dyna, request, response);
    }

    public static void main(String[] args) {
    }
}