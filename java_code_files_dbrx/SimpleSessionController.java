import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;

@Controller
public class SimpleSessionController {
    @GetMapping("/session/{id}")
    public String handle(@PathVariable("id") Long id, HttpSession httpSession) {
        // Your logic here... like saving the session ID or some other info in request scope etc.
        httpSession.setAttribute("someAttributeName", "someValue");
        return "page";
    }

    public static void main(String[] args) {
    }
}