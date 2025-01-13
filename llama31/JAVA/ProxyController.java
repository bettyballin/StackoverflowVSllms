import java.lang.String;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ProxyController {
    @GetMapping("/restricted-uri")
    public String proxyRequest() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://restricted-uri.com", String.class);
        return response;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProxyController.class, args);
    }
}