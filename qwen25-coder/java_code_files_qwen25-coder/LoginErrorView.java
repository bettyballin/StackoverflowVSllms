import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class LoginErrorView {
    public ModelAndView getLoginErrorView() {
        Map<String, Object> model = new HashMap<>();
        model.put("errors", "example error");
        return new ModelAndView(new RedirectView("login.htm"), model);
    }

    public static void main(String[] args) {
        LoginErrorView loginErrorView = new LoginErrorView();
        ModelAndView modelAndView = loginErrorView.getLoginErrorView();
        System.out.println("ModelAndView: " + modelAndView);
    }
}