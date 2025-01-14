import java.lang.String;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController_8 {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }

    public static void main(String[] args) {
    }
}

// Dummy implementations to make the code executable with javac
class UserService {
    public Object getAllUsers() {
        return null;
    }
}

class Model {
    public void addAttribute(String key, Object value) {
    }
}