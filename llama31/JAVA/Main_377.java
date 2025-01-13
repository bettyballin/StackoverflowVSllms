import java.security.Permission;
import java.security.Permissions;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.security.RuntimePermission;

public class Main_377 {
    public static void main(String[] args) {
        Policy policy = Policy.getPolicy();
        Permissions permissions = new Permissions();
        permissions.add(new RuntimePermission("accessClassInPackage.javax.naming"));
        policy.addPermissions(new ProtectionDomain(null, permissions));
    }
}