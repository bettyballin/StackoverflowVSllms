import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class UserRoleUtil {
    public static String[] getUserRoles(HttpServletRequest request) {
        Principal userPrincipal = request.getUserPrincipal();
        if (userPrincipal == null) {
            return new String[0];
        }

        // You need to cast to a specific Principal implementation 
        // that has a method to get the roles. Here we assume it's a 
        // java.security.Principal that has a method called "getRoles"
        // You may need to adjust this to your actual Principal implementation.
        // For demonstration purposes, let's assume YourPrincipalImplemention is a valid class
        String[] roles = ((YourPrincipalImplemention) userPrincipal).getRoles();
        return roles;
    }

    public static void main(String[] args) {
        // For demonstration purposes only
        // In a real application, you would get the HttpServletRequest from your web framework
        HttpServletRequest request = null; // Initialize with your actual HttpServletRequest
        String[] roles = getUserRoles(request);
        for (String role : roles) {
            System.out.println(role);
        }
    }
}

// For demonstration purposes, let's assume YourPrincipalImplemention is a valid class
class YourPrincipalImplemention implements Principal {
    private String[] roles;

    public YourPrincipalImplemention(String[] roles) {
        this.roles = roles;
    }

    public String[] getRoles() {
        return roles;
    }

    @Override
    public String getName() {
        return null; // Implement as needed
    }
}