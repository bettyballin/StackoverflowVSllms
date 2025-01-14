import java.util.HashMap;
import java.util.Map;
import java.security.Principal;

// Custom Principal class for roles
class RolePrincipal implements Principal {
    private String name;

    public RolePrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Custom User class to hold user information along with their roles (principals)
class UserDetails {
    private String username;
    private Map<String, Principal> roles;

    public UserDetails(String username) {
        this.username = username;
        this.roles = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void addRole(Principal role) {
        roles.put(role.getName(), role);
    }

    public Map<String, Principal> getRoles() {
        return roles;
    }
}

// Global registry to hold user details
class UserRegistry {
    private final Map<String, UserDetails> users = new HashMap<>();

    public synchronized void addUser(UserDetails userDetails) {
        this.users.put(userDetails.getUsername(), userDetails);
    }

    public synchronized UserDetails getUser(String username) {
        return this.users.get(username);
    }
}

// Example usage
public class RoleAccessExample {
    static final UserRegistry globalRegistry = new UserRegistry();

    // This method would be called from your login module or similar after successful authentication
    static void postLoginCallback(String username, Principal... roles) {
        UserDetails userDetails = new UserDetails(username);
        for (Principal role : roles) {
            userDetails.addRole(role);
        }
        globalRegistry.addUser(userDetails);
    }

    // Method to get user roles anywhere in your application
    public static Map<String, Principal> getUserRoles(String username) {
        UserDetails userDetails = globalRegistry.getUser(username);
        if (userDetails != null) {
            return userDetails.getRoles();
        } else {
            throw new RuntimeException("User not found: " + username);
        }
    }

    // Example of using the system
    public static void main(String[] args) {
        // Simulate login for user Fred with some roles
        postLoginCallback("Fred", new RolePrincipal("Admin"), new RolePrincipal("User"));

        // Access roles anywhere in your application
        Map<String, Principal> fredRoles = getUserRoles("Fred");
        System.out.println("Fred's Roles: " + fredRoles.keySet());
    }
}