import java.lang.String;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Controller {
    @PostMapping("/your-endpoint")
    public String yourMethod(@RequestParam("id") String[] ids) {
        // Use the ids array as needed
        return "Hello, World!";
    }

    public static void main(String[] args) {
    }
}