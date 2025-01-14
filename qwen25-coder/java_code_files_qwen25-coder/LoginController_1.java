import java.lang.String;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Controller {}

@Retention(RetentionPolicy.RUNTIME)
@interface RequestMapping {
    String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@interface GetMapping {
    String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@interface PostMapping {
    String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@interface RequestParam {
    String value() default "";
}

@Controller
@RequestMapping("/login")
public class LoginController_1 {

    @GetMapping("")
    public String loginPage() {
        return "login";
    }

    @PostMapping("")
    public String processLogin(@RequestParam String username, @RequestParam String password) {
        // Simplified user validation logic
        if ("admin".equals(username) && "password".equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }

    public static void main(String[] args) {
    }
}