import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users/{id}")
public class UserController_2_2 {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(params = "format=html")
    public String getUserHtml(@PathVariable Long id, org.springframework.ui.Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user"; // returns an HTML view
    }

	public static void main(String[] args) {
	}
}