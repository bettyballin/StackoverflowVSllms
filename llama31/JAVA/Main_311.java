import java.security.Permission;
import java.security.Policy;
import java.security.CodeSource;
import java.io.FilePermission;

public class Main_311 {
    public static void main(String[] args) {
        Policy policy = Policy.getPolicy();
        CodeSource codeSource = new CodeSource(null, (java.security.cert.Certificate[]) null);
        Permission permission = new FilePermission("kb1.xml", "read");
        policy.addPermission(permission);
        System.out.println("Permission added successfully");
    }
}