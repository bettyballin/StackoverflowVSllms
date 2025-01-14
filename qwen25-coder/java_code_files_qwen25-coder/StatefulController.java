import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
@SessionAttributes({"user"})
public class StatefulController {

    @PostMapping("/login")
    public String login(@RequestParam String user, Model model) {
        // Store the user's name in the session for demonstration purposes.
        model.addAttribute("user", user);
        return "User " + user + " logged in successfully.";
    }

    @GetMapping("/status")
    public String getUser(HttpSession session) {
        // Retrieve the user from the session
        Object user = session.getAttribute("user");
        if (user != null) {
            return "Current user: " + user;
        } else {
            return "No user logged in.";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session and log out
        session.invalidate();
        return "User logged out successfully.";
    }

    public static void main(String[] args) {
    }
}