import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

public class AccessControl {
    public enum Role { ADMIN, EDITOR, VIEWER }

    private Map<Role, Set<String>> permissionsByRole = new HashMap<>();

    public AccessControl() {
        initializePermissions();
    }

    private void initializePermissions() {
        permissionsByRole.put(Role.ADMIN, new HashSet<>(Arrays.asList("view", "edit", "delete")));
        permissionsByRole.put(Role.EDITOR, new HashSet<>(Arrays.asList("view", "edit")));
        permissionsByRole.put(Role.VIEWER, new HashSet<>(Arrays.asList("view")));
    }

    public boolean isAllowed(Role role, String action) {
        Set<String> allowedActions = permissionsByRole.get(role);
        return allowedActions != null && allowedActions.contains(action.toLowerCase());
    }
}

// Usage example
public class TestAccessControl {
    public void performActionIfNeeded(AccessControl accessControl, AccessControl.Role userRole, String desiredAction) {
        if (accessControl.isAllowed(userRole, desiredAction)) {
            // Perform the action
            System.out.println("Action performed: " + desiredAction);
        } else {
            throw new SecurityException("User does not have permission to perform: " + desiredAction);
        }
    }

    public static void main(String[] args) {
        AccessControl accessControl = new AccessControl();
        AccessControl.Role userRole = AccessControl.Role.ADMIN;
        String desiredAction = "delete";

        TestAccessControl test = new TestAccessControl();
        test.performActionIfNeeded(accessControl, userRole, desiredAction);
    }
}