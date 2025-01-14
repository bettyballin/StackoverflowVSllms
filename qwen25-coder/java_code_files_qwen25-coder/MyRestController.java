import java.lang.String;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Java!";
    }

	public static void main(String[] args) {
	}
}