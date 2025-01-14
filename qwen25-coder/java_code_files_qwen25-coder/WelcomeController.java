import java.lang.String;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to our community platform!";
    }

	public static void main(String[] args) {
	}
}