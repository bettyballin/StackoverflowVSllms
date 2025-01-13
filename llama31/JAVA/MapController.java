import java.lang.String;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class MapController {
    @GetMapping("/service/{x}/{y}/{z}")
    public String myMethod(@PathVariable String x, @PathVariable String y, @PathVariable String z) {
        // ...
        return "";
    }

    public static void main(String[] args) {
    }
}