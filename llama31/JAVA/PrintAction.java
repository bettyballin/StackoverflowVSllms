import java.lang.String;

// Define the Permission enum
enum Permission {
    PRINT
}

// Define the Role enum
enum Role {
    // Add your roles here
    ADMIN, USER
}

// Define the SecurityManager class
class SecurityManager {
    private static SecurityManager instance;

    private SecurityManager() {}

    public static SecurityManager getInstance() {
        if (instance == null) {
            instance = new SecurityManager();
        }
        return instance;
    }

    public boolean hasPermission(Role role, Permission permission) {
        // Implement your permission logic here
        return true; // For now, always return true
    }
}

public abstract class Action {
    private Permission permission;

    public Action(Permission permission) {
        this.permission = permission;
    }

    public boolean isAuthorized(Role role) {
        return SecurityManager.getInstance().hasPermission(role, permission);
    }
}

public class PrintAction extends Action {
    public PrintAction() {
        super(Permission.PRINT);
    }

    public void execute() {
        // Printing logic
    }

    public static void main(String[] args) {
        PrintAction printAction = new PrintAction();
        System.out.println(printAction.isAuthorized(Role.ADMIN));
    }
}