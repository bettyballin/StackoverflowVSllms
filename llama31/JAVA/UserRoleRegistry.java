import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserRoleRegistry {
    private Map<String, Set<Principal>> userRoles = new HashMap<>();

    public void registerUserRoles(String username, Set<Principal> roles) {
        userRoles.put(username, roles);
    }

    public Set<Principal> getUserRoles(String username) {
        return userRoles.get(username);
    }

    public static void main(String[] args) {
    }
}