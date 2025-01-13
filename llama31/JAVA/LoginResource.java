import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginResource {
    public void login(HttpServletRequest request, String username) {
        HttpSession session = request.getSession(true); // create a new session if one doesn't exist
        // add user data to the session
        session.setAttribute("username", username);
    }

	public static void main(String[] args) {
	}
}