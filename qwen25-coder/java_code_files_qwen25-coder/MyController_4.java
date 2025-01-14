import java.lang.String;

@Controller
public class MyController_4 {

    @RequestMapping("/myPage")
    public String showMyPage(HttpServletRequest request) {
        Foo foo = new Foo();
        // Initialize foo...
        request.setAttribute("foo", foo);
        return "myJsp";
    }

    public static void main(String[] args) {
    }

    // Define the Foo class
    public static class Foo {
        // Add fields and methods as needed
    }
}

// Define the Controller annotation
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Controller {
}

// Define the RequestMapping annotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@interface RequestMapping {
    String value() default "";
}

// Define the HttpServletRequest class
class HttpServletRequest {
    public void setAttribute(String name, Object value) {
        // Implementation goes here
    }
}