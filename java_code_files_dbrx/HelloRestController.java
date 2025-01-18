import org.springframework.web.bind.annotation.GetMapping;

public class HelloRestController {
    @GetMapping("/")
    public String sampleEndpoint() {
        return "Hello, REST!";
    }

    public static void main(String[] args) {
    }
}