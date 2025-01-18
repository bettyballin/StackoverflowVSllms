import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class object {
    public void handleUserApiRequest(HttpServletRequest request, HttpServletResponse response) {
        // Handle HTTP request & construct 'user' class object.
        user user = new user();
        user.add();  // Add user to DB via user class method, instead of separate API add code implementation
    }
    public static void main(String[] args) {
    }
}

class user {
    public void add() {
        // implementation
    }
}