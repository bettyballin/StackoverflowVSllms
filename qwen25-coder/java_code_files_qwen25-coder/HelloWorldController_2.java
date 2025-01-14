import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController_2 {

    private final UserService userService;

    @Autowired
    public HelloWorldController_2(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = userService.lookupUser("helloUser");
        return new ModelAndView("HelloWorld", "user", user);
    }

    public static void main(String[] args) {
    }
}

interface UserService {
    User lookupUser(String username);
}

class User {
}