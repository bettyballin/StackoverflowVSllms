import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Assuming @UserId is a custom annotation, define it if not already
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface UserId {
}

@Controller // Assuming this is a Spring Controller
public class UserProfileController {

    @GetMapping("/profile/{id}")
    public ModelAndView viewProfile(@PathVariable @UserId Long id) {
        // Implementation details
        return new ModelAndView(); // Placeholder, implement as needed
    }

    public static void main(String[] args) {
        // Typically, a Spring application would be launched differently,
        // but for a simple class compilation and execution test, this can be empty.
    }
}