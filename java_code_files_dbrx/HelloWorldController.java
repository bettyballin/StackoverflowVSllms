import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello, world!";
    }

    public static void main(String[] args) {
    }
}