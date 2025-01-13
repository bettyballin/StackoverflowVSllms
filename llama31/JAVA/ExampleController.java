import java.lang.String;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ExampleController {
    // Java example using Thymeleaf
    @GetMapping("/example")
    public String example(Model model) {
        model.addAttribute("data", "Hello, World!");
        return "example"; // renders example.html template
    }
    public static void main(String[] args) {
    }
}