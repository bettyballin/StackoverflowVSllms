import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("greeting", "Hello, World!");
        return "hello";
    }

    public static void main(String[] args) {
    }
}