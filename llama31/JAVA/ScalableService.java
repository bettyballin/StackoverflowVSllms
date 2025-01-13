import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScalableService {
    @GetMapping("/api/data")
    public String getData() {
        // Return cached or computed data
        return "Hello, World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ScalableService.class, args);
    }
}