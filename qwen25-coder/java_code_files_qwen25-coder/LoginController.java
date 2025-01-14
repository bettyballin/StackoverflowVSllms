import java.lang.String;
import java.util.Map;
import java.util.HashMap;

public class LoginController {

    public ModelAndView login() {
        RedirectAttributes redirectAttributes = new RedirectAttributes();
        redirectAttributes.addFlashAttribute("errors", "example error");
        return new ModelAndView(new RedirectView("login.htm"), redirectAttributes.asMap());
    }

    public static void main(String[] args) {
    }
}

class RedirectAttributes {
    public void addFlashAttribute(String key, String value) {
        // Method implementation
    }

    public Map<String, Object> asMap() {
        // Method implementation
        return new HashMap<String, Object>();
    }
}

class ModelAndView {
    public ModelAndView(RedirectView redirectView, Map<String, Object> model) {
        // Constructor implementation
    }
}

class RedirectView {
    public RedirectView(String url) {
        // Constructor implementation
    }
}