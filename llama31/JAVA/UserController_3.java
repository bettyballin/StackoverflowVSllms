import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.annotation.Valid;

@Controller
public class UserController_3_3 {
    @PostMapping("/users")
    public String createUser(@Valid UserCommand command, BindingResult result) {
        if (result.hasErrors()) {
            // handle errors
        }
        // create user
        return "";
    }

    public static void main(String[] args) {
    }
}

class UserCommand {
    // Add fields and getters/setters as needed
}