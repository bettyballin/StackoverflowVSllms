import java.security.Permission;

public class GroovySecurityManager extends SecurityManager {
    // Removed @Override annotation to ensure compatibility with newer Java versions
    public void checkMemberAccess(Class<?> clazz, int which) throws SecurityException {
        // List of methods you want to block here
        if (clazz.getName().equals("com.example.ForbiddenClass") && "forbiddenMethod".equals(clazz.getSimpleName())) {
            throw new SecurityException("Access denied");
        }
        super.checkMemberAccess(clazz, which);
    }

    @Override
    public void checkPermission(Permission perm) {
        // Optionally block specific permissions here
        super.checkPermission(perm);
    }

    // Main method to set the security manager
    public static void main(String[] args) {
        System.setSecurityManager(new GroovySecurityManager());
        // Now run your groovy script code here
    }
}