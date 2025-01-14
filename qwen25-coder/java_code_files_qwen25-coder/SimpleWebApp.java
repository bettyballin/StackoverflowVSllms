import java.lang.String;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SimpleWebApp {

    @RestController
    static class HelloController {
        @GetMapping("/hello")
        String sayHello() {
            return "Hello, World!";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleWebApp.class, args);
    }
}