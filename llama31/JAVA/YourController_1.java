import java.lang.String;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class YourController_1_1 {
    
    @PostMapping("/your-endpoint")
    public String handleRequest(@RequestBody String xmlString) {
        // Process the XML string
        return "processed xml string";
    }

	public static void main(String[] args) {
	}
}