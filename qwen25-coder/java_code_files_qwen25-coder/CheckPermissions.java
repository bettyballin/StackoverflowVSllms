import java.lang.String;
public class CheckPermissions {
    public static void main(String[] args) {
        try {
            System.getProperty("user.home");
            System.out.println("Access to user home directory permitted.");
            
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkPermission(new java.io.FilePermission("/path/to/resource", "read"));
                System.out.println("Read access to /path/to/resource is permitted.");
            }
        } catch (SecurityException se) {
            System.err.println(se.getMessage());
        }
    }
}