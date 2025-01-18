import java.lang.String;
import org.springframework.web.bind.annotation.RequestMapping;

public class SampleController {
    @RequestMapping("/sample")
    public String sample() {
        // This will cause the "index" resolvable to be resolved using
        // Thymeleaf based on our configuration
        return "base"; // name of your base template. The controller will inject the fragment you need into placeholders defined in this layout(base) file and thus creating a new webpage.
    }

    public static void main(String[] args) {
    }
}