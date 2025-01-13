import java.io.FilePermission;
import java.security.Permission;
import java.security.Policy;
import java.security.ProtectionDomain;

public class GrantPermissions_1 {
    public static void main(String[] args) {
        // Create a new FilePermission
        Permission permission = new FilePermission("/var/data/tdb/*", "read, write, delete");

        // Get the current policy
        Policy policy = Policy.getPolicy();

        // Create a new ProtectionDomain
        ProtectionDomain domain = new ProtectionDomain(null, null);

        // Add the permission to the policy
        policy.addPermission(permission); // Policy addPermission method takes only one argument
    }
}