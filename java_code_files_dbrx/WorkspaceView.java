import java.lang.annotation.*;
import java.util.*;

// Define the RequireAccess annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RequireAccess {
    String Right();
}

// Base View class
class View {
    // Base View class implementation
}

// WorkspaceView class with the RequireAccess annotation
@RequireAccess(Right = "module.view")
public class WorkspaceView extends View {
    // ... class implementation
}

// SecurityManager class
public class SecurityManager {
    private static Map<String, Boolean> currentUserPermissionsMap = new HashMap<>();

    public static boolean hasAccess(String requiredPermission) {
        return currentUserPermissionsMap.get(requiredPermission);
    }
}

// Usage example
if (SecurityManager.hasAccess("module.view")) {
    showView();
}