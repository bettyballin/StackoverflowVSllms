import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class YourController {
    @GetMapping("/get-string")
    public String getString() {
        return "Some string from controller";
    }

    public static void main(String[] args) {
    }
}