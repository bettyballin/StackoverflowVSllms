import java.lang.String;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class UserController {

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            // Validation error handling
            return "createUser";
        } else {
            // Save or update the object
            return "success";
        }
    }

    public static void main(String[] args) {
    }
}

class User {
    // User class implementation
}