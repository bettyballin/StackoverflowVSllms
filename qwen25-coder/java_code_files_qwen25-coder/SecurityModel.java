import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;

public class SecurityModel {
    private Map<String, Set<String>> rolePermissions;

    public SecurityModel() {
        rolePermissions = new HashMap<>();
        // Define whitelisted actions for roles
        defineRolePermissions();
    }

    private void defineRolePermissions() {
        rolePermissions.put("admin", new HashSet<>(Arrays.asList("viewAllData", "deleteUser", "modifyUser")));
        rolePermissions.put("user", new HashSet<>(Arrays.asList("viewOwnData")));
        // More roles and permissions can be added here
    }

    public boolean hasPermission(String userRole, String action) {
        return rolePermissions.getOrDefault(userRole, Collections.emptySet()).contains(action);
    }

    public static void main(String[] args) {
        SecurityModel security = new SecurityModel();
        System.out.println(security.hasPermission("admin", "deleteUser")); // true
        System.out.println(security.hasPermission("user", "viewAllData"));  // false
    }
}