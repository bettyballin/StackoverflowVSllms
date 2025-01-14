import java.lang.String;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataController {

    @GetMapping("/data")
    public String getData() {
        // Return data as JSON string
        return "{\"message\": \"Hello from REST API\"}";
    }

	public static void main(String[] args) {
	}
}