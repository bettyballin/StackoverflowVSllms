import java.security.Policy;
import java.security.Permission;

public class Main_202 {
    public static void main(String[] args) {
        // Load the policy file
        System.setProperty("java.security.manager", "");
        System.setProperty("java.security.policy", "file:/path/to/your/policyfile.policy");

        // Get the current policy
        Policy policy = Policy.getPolicy();

        // Test the permission
        Permission perm = new java.lang.RuntimePermission("accessClassInPackage.java.io");
        if (policy.implies(System.getSecurityManager().getThreadGroup(), perm)) {
            System.out.println("Permission granted");
        } else {
            System.out.println("Permission denied");
        }
    }
}