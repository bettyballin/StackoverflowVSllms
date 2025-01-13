import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class RequestParamController {
    @GetMapping("/service")
    public String myMethod(@RequestParam String x, @RequestParam String y, @RequestParam String z) {
        // ...
        return "Hello, World!";
    }

    public static void main(String[] args) {
    }
}