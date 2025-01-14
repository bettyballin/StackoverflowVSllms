import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction_1 extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginForm loginForm = (LoginForm) form;
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        // Simple validation for demonstration
        if (!"user".equals(username) || !"pass".equals(password)) {
            ActionErrors actionErrors = new ActionErrors();
            actionErrors.add("error.login.failed", new ActionError("errors.login.failed"));
            saveErrors(request, actionErrors);
            return mapping.findForward("failure");
        }

        return mapping.findForward("success");
    }

    public static void main(String[] args) {
    }
}

// Define the LoginForm class used in the code
import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
    private String username;
    private String password;

    // Getters and setters for username and password
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
         return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}