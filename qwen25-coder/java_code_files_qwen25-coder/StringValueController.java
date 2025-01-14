import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringValueController {
    @GetMapping("/getValue")
    public @ResponseBody String getValue() {
        return "yourString"; // This is the string value you want to retrieve
    }

    public static void main(String[] args) {
        // You can add code here to run your application if needed
    }
}