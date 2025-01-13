import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

// A simple class to encapsulate the getUserRoles method
public class UserRoleChecker {

    public String[] getUserRoles(HttpServletRequest request) {
        List<String> roles = new ArrayList<>();
        // Define all possible roles
        String[] allRoles = {"admin", "moderator", "user"};
        for (String role : allRoles) {
            if (request.isUserInRole(role)) {
                roles.add(role);
            }
        }
        return roles.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Simulating HttpServletRequest for demonstration
        // This is not how you'd actually do it in a web app, but for the sake of compilation and execution
        HttpServletRequest request = null; // In a real scenario, you wouldn't manually create this
        // Since we're simulating, we can't actually call getUserRoles with a meaningful request
        System.out.println("This is a simulation and doesn't actually check user roles.");
        // In a real web application, you'd call getUserRoles with an actual HttpServletRequest object
    }
}