import java.security.Permission;
import java.security.SecurityManager;

public class PermissiveSecurityManager {
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                // Grant all permissions
                return;
            }
        });
    }
}