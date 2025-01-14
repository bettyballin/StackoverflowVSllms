import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController_7 {

    @GetMapping("/register")
    public String showRegistrationForm(UserForm userForm) {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        // Save the user and redirect
        return "redirect:/success";
    }

    public static void main(String[] args) {
    }
}