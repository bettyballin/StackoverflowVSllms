import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Struts 1 Action
public class MyAction_8_8 extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        // ...
        return null;
    }
}

// Equivalent Spring MVC Controller
@RestController
public class MyController {
    @RequestMapping(value = "/myAction", method = RequestMethod.GET)
    public String myAction(Model model) {
        // ...
        return null;
    }

	public static void main(String[] args) {
	}
}