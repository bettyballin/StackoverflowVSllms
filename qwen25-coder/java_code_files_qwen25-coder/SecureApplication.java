import java.lang.String;
import java.lang.reflect.Method;
import java.security.Permission;

public class SecureApplication {
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                // Allow only "exitVM" and deny everything else.
                if (!perm.getName().equals("exitVM")) {
                    throw new SecurityException("Access denied: " + perm);
                }
            }

            @Override
            public void checkMemberAccess(Class<?> clazz, int which) {
                super.checkMemberAccess(clazz, which);
                // Add more checks as necessary to restrict access patterns.
                if (clazz.getName().equals("TargetClass")) {
                    throw new SecurityException("Reflective access to TargetClass is not allowed.");
                }
            }

            @Override
            public void checkPackageAccess(String pkg) {
                super.checkPackageAccess(pkg);
                // Add more checks as necessary.
                if (pkg.startsWith("com.example")) {
                    throw new SecurityException("Package access for " + pkg + " not permitted.");
                }
            }
        });

        try {
            Class<?> targetClass = Class.forName("TargetClass");
            Method[] methods = targetClass.getDeclaredMethods();
            methods[0].setAccessible(true); // This should now cause a SecurityException
            String sensitiveData = (String) methods[0].invoke(null, (Object[]) null);
            System.out.println("Sensitive Data: " + sensitiveData);
        } catch (SecurityException e) {
            System.err.println("Operation not permitted: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}