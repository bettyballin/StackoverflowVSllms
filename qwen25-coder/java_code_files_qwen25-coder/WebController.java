import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// Example of a simple controller
@RestController
public class WebController {

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
    }
}