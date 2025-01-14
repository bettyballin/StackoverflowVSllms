import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController_9 {

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation error, return to registration form with error messages
            return "registration";
        }
        // Proceed with registration
        return "success";
    }

    public static void main(String[] args) {
    }
}

// Supporting classes and interfaces for compilation
class User {
    // Empty implementation for compilation purposes
}

interface BindingResult {
    boolean hasErrors();
}

@interface Controller {}

@interface PostMapping {
    String value() default "";
}

@interface ModelAttribute {}

@interface Valid {}