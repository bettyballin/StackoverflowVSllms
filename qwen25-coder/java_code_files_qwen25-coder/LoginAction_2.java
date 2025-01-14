import java.lang.String;

public class LoginAction_2 extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        LoginForm loginForm = (LoginForm) form;
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        // Simplified user validation logic
        if ("admin".equals(username) && "password".equals(password)) {
            return mapping.findForward("success");
        } else {
            return mapping.findForward("failure");
        }
    }

    public static void main(String[] args) throws Exception {
        LoginAction_2 action = new LoginAction_2();
        ActionMapping mapping = new ActionMapping();
        LoginForm form = new LoginForm("admin", "password");
        HttpServletRequest request = new HttpServletRequest();
        HttpServletResponse response = new HttpServletResponse();

        action.execute(mapping, form, request, response);
    }
}

// Minimal Class Definitions
class Action {
}

class ActionForward {
}

class ActionMapping {
    public ActionForward findForward(String name) {
        System.out.println("Forwarding to " + name);
        return new ActionForward();
    }
}

class ActionForm {
}

class HttpServletRequest {
}

class HttpServletResponse {
}

class LoginForm extends ActionForm {
    private String username;
    private String password;

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    } 

    public String getPassword() {
        return password;
    }
}