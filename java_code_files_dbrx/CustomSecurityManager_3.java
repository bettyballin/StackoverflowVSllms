import java.security.Permission;

public class CustomSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        // If the current Thread's stack trace does not contain any of your whitelisted methods throw an exception.
    }
}