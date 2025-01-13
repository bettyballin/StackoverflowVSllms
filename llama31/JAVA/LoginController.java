import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class LoginController {
    public ModelAndView login(Object model) {
        ModelAndView mv = new ModelAndView(new RedirectView("login.htm"));
        mv.addObject("model", model);
        return mv;
    }

    public static void main(String[] args) {
    }
}