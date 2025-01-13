import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

// Java Backend (e.g., Spring MVC)
@RestController
@RequestMapping("/api")
public class MyController_7_7 {
    @GetMapping("/data")
    public String getData() {
        // Return data in JSON format
        return "{\"name\":\"John\",\"age\":30}";
    }

	public static void main(String[] args) {
	}
}