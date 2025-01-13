import java.lang.String;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YourController {
    @GetMapping("/YourMethod")
    public String yourMethod() {
        // Return the value you need
        return "YourValue";
    }

    public static void main(String[] args) {
    }
}