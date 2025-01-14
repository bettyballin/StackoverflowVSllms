import java.security.Permission;

public class CustomSecurityManager extends SecurityManager {
    private static final String[] FORBIDDEN_CLASSES = {
        "javax.naming.NamingException",
        // Add other forbidden classes here
    };

    @Override
    public void checkPackageAccess(String pkg) {
        for (String cls : FORBIDDEN_CLASSES) {
            if (cls.startsWith(pkg)) {
                throw new SecurityException("Access to package " + pkg + " is denied.");
            }
        }
    }

    @Override
    public void checkPermission(Permission perm) {
        // Custom permission checks can go here
    }

    public static void main(String[] args) {
        System.setSecurityManager(new CustomSecurityManager());

        try {
            Class.forName("javax.naming.NamingException");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("Attempted access to forbidden class: " + e.getMessage());
        }
    }
}