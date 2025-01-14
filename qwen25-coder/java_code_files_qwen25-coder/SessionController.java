import java.lang.String;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    // Create a new session - PUT /session/{username}
    @PutMapping("/session/{username}")
    public String createSession(@PathVariable String username, HttpSession session) {
        if (session.isNew()) {
            session.setAttribute("user", username);
            return "Session created for user: " + username;
        }
        else {
            // Optionally handle the case where a session already exists
            return "User " + username + " is already logged in.";
        }
    }

    // Destroy the existing session - DELETE /session/{username}
    @DeleteMapping("/session/{username}")
    public String destroySession(HttpSession session) {
        if (session != null) {
            session.invalidate();
            return "Session destroyed.";
        } else {
            return "No session to invalidate.";
        }
    }

	public static void main(String[] args) {
	}
}