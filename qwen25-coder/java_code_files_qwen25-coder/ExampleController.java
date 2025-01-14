import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleController {

    @RequestMapping("/example")
    public ModelAndView example() {
        // Business logic here
        String result = "Hello, world!";
        return new ModelAndView("example", "result", result);
    }

    public static void main(String[] args) {
    }
}