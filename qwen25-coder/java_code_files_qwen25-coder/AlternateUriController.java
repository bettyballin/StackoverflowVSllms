import java.lang.String;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alternate-uri")
public class AlternateUriController {

    @GetMapping
    public ResponseEntity<String> getAlternateUri() {
        // Define the canonical URI
        String canonicalURI = "/canonical-uri";

        // Send a 302 redirect to the canonical URI
        return ResponseEntity.status(HttpStatus.MOVED_TEMPORARILY)
                .header("Location", canonicalURI)
                .body("This resource has moved temporarily. Please use " + canonicalURI);
    }

	public static void main(String[] args) {
	}
}