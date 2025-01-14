import java.lang.String;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class DataService_1 {
    // Simple example of SOA approach using RESTful API in Java (Spring Boot)
    @RestController
    class DataService {
        @GetMapping("/data")
        public String getData() {
            // Logic to fetch data
            return "Data";
        }
    }

    public static void main(String[] args) {
    }
}