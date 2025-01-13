import java.lang.reflect.Method;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;
import java.security.ProtectionDomain;

public class SecureTargetClass {
    private static String SENSITIVE_DATA = "sw0rdfish";

    private static String getSensitiveData() {
        return SENSITIVE_DATA;
    }

    public static void main(String[] args) {
        // Set up a Security Manager
        System.setSecurityManager(new SecurityManager());

        // Define a custom policy that restricts access to the private method
        Policy policy = new Policy() {
            @Override
            public PermissionCollection getPermissions(ProtectionDomain domain) {
                Permissions permissions = new Permissions();
                // Add permissions for the code to execute, but not to access private methods
                permissions.add(new RuntimePermission("accessClassInPackage.*"));
                return permissions;
            }
        };

        // Set the custom policy
        System.setSecurityPolicy(policy);

        try {
            // Try to access the private method using Reflection
            Class<?> targetClass = Class.forName("SecureTargetClass");
            Method[] methods = targetClass.getDeclaredMethods();
            methods[0].setAccessible(true); // This will throw a SecurityException
            String sensitiveData = (String) methods[0].invoke(null, null);
            System.out.println("Sensitive Data: " + sensitiveData);
        } catch (SecurityException e) {
            System.out.println("Access denied!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}