import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Controller { }

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface GetMapping {
    String value();
}

@Controller
public class MyController_2 {

    @GetMapping("/header")
    public String header() {
        return "header";  // Maps to header.jsp
    }

    @GetMapping("/body")
    public String body() {
        return "body";  // Maps to body.jsp
    }

    @GetMapping("/footer")
    public String footer() {
        return "footer";   // Maps to footer.jsp
    }

    public static void main(String[] args) {
    }
}