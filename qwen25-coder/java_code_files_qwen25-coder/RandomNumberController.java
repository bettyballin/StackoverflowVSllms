import java.lang.String;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {

    @GetMapping("/generateRandom")
    public int generateRandom() {
        return (int) (Math.random() * 100);
    }

	public static void main(String[] args) {
	}
}