// Define a simple placeholder for JettyRealm to make the code compilable
class JettyRealm {
    // Placeholder method to simulate getUserRoles
    public Set<Principal> getUserRoles(String username) {
        // For demonstration purposes, return a simple set with one role
        Set<Principal> roles = new java.util.HashSet<>();
        roles.add(new Principal() {
            @Override
            public String getName() {
                return "Admin";
            }
        });
        return roles;
    }
}

import java.security.Principal;
import java.util.Set;

public class Main_685 {
    public static void main(String[] args) {
        // Get the JettyRealm instance
        JettyRealm realm = new JettyRealm();

        // Get the roles of a user named "Fred"
        Set<Principal> roles = realm.getUserRoles("Fred");

        // Print the roles
        System.out.println(roles);
    }
}