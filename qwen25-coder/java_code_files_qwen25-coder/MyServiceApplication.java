import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyServiceApplication.class, args);
    }

    @RestController
    static class SimpleController {

        @GetMapping("/api/greet")
        public String greet() {
            return "Hello, from a simple service!";
        }
    }
}