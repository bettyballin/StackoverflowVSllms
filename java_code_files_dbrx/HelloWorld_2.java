import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

// Example usage with Spring Boot using its embedded server:
@RestController
public class HelloWorld_2 {
    @RequestMapping("/")
    public String index() {
        return "Hello, World!";
    }
}

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}