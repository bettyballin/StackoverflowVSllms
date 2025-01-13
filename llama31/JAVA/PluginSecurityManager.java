import java.lang.String;
import java.security.Permission;
import java.security.SecurityManager;

public class PluginSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        // Restrict plug-ins from starting new processes
        if (perm instanceof RuntimePermission && perm.getName().equals("getenv.*")) {
            throw new SecurityException("Plug-in is not allowed to start a new process");
        }
        // Allow other permissions
        super.checkPermission(perm);
    }

    public static void main(String[] args) {
        System.setSecurityManager(new PluginSecurityManager());
    }
}