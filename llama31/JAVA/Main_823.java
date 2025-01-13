import java.lang.String;
import java.lang.SecurityManager;
import java.lang.RuntimePermission;

public class Main_823 {
    public static void main(String[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            try {
                securityManager.checkPermission(new RuntimePermission("exec"));
                System.out.println("Runtime.exec is allowed");
            } catch (SecurityException e) {
                System.out.println("Runtime.exec is not allowed");
            }
        } else {
            System.out.println("No SecurityManager, assuming Runtime.exec is allowed");
        }
    }
}