import java.security.Permission;
import java.security.RuntimePermission;

public class MySecurityManager_1 extends SecurityManager {
    public void checkPermission(Permission perm) {
        if (perm instanceof RuntimePermission && "accessClassInPackage.javax.naming".equals(perm.getName())) {
            throw new SecurityException("Access to package javax.naming not allowed");
        }
        super.checkPermission(perm);
    }

    public static void main(String[] args) {
    }
}