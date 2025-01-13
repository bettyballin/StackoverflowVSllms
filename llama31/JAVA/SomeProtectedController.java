import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Assuming @LoginRequired is a custom annotation, you need to import it
// If it's not a custom annotation, you need to import it from the correct package
import your.package.LoginRequired;

@Controller
public class SomeProtectedController {

    @LoginRequired
    @RequestMapping("/someProtectedMethod")
    public String someProtectedMethod() {
        // method implementation
        return ""; // You need to return a String here
    }

    public static void main(String[] args) {
    }
}