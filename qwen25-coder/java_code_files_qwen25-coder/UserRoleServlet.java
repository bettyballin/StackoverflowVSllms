import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/getUserRoles")
public class UserRoleServlet extends HttpServlet {
    // Simulated map of users to roles, in a real application this would be dynamic
    private static final Map<String, String[]> userRolesMap = new HashMap<>();

    static {
        userRolesMap.put("user1", new String[]{"role1", "role2"});
        userRolesMap.put("user2", new String[]{"role3"});
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getRemoteUser(); // This retrieves the logged-in username

        if (username != null && userRolesMap.containsKey(username)) {
            String[] roles = userRolesMap.get(username);
            response.getWriter().write("User " + username + " has roles: " + Arrays.toString(roles));
        } else {
            response.getWriter().write("User not found or no roles assigned.");
        }
    }

    public static void main(String[] args) {
    }
}