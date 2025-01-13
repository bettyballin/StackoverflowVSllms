import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import java.util.Locale;

public class LoginController_1_1 {
    public ModelAndView login(Locale locale, Object model) {
        return new ModelAndView(new InternalResourceViewResolver().resolveViewName("login.htm", locale), "model", model);
    }

    public static void main(String[] args) {
        // You may want to create an instance of LoginController_1 and call the login method
        // For example:
        // LoginController_1 controller = new LoginController_1();
        // controller.login(Locale.getDefault(), new Object());
    }
}