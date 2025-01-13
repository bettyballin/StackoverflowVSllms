import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserController_7_7 {
    // Java method returns data in JSON format
    @RequestMapping("/users")
    public @ResponseBody List<User> getUsers() {
        // Fetch data from DB
        List<User> users = userService.getUsers();
        return users;
    }

    public static void main(String[] args) {
    }
}