import java.lang.String;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CognosApi {

    @GetMapping("/data")
    public String getData() {
        // Call COGNOS 7 API using a more modern and secure approach
        return "Data from COGNOS 7";
    }

    public static void main(String[] args) {
        SpringApplication.run(CognosApi.class, args);
    }
}