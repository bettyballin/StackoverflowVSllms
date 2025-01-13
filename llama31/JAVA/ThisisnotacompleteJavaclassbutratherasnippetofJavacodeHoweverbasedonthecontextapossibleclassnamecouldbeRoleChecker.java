import java.lang.String;

public class RoleChecker {
    public static void main(String[] args) {
        // Assuming req is an HttpServletRequest object
        // For demonstration purposes, we'll create a mock HttpServletRequest
        HttpServletRequest req = new HttpServletRequest() {
            @Override
            public boolean isUserInRole(String role) {
                // Mock implementation for demonstration purposes
                return role.equals("someRole");
            }
        };

        if (req.isUserInRole("someRole")) {
            System.out.println("User is in the role");
        } else {
            System.out.println("User is not in the role");
        }
    }
}