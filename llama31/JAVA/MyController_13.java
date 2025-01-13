import java.lang.String;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController_13_13 {
    @RequestMapping("/submit")
    public String submit(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            // handle errors
        } else {
            // handle valid object
        }
        return "";
    }

    public static void main(String[] args) {
    }
}

class User {
    // User class is required for the @Valid annotation to work
}