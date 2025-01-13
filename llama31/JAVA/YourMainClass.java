import java.lang.String;
import java.lang.reflect.ReflectPermission;
import java.security.CodeSource;
import java.security.Permission;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.security.SecurityManager;
import java.security.cert.Certificate;

public class YourMainClass {
  public static void main(String[] args) {
    // Create a new SecurityManager
    SecurityManager sm = new SecurityManager();
    
    // Set the policy
    Policy.setPolicy(new Policy() {
      @Override
      public boolean implies(ProtectionDomain domain, Permission permission) {
        if (permission instanceof RuntimePermission) {
          if (permission.getName().startsWith("accessClassInPackage.java.io")) {
            return false;
          }
        }
        return true;
      }
      
      @Override
      public void refresh() {
        // Not implemented
      }

      @Override
      public PermissionCollection getPermissions(CodeSource codesource) {
        // Not implemented
        return null;
      }

      @Override
      public PermissionCollection getPermissions(ProtectionDomain domain) {
        // Not implemented
        return null;
      }

      @Override
      public boolean implies(ProtectionDomain domain, Permission permission, CodeSource codesource) {
        // Not implemented
        return implies(domain, permission);
      }
    });
    
    // Enable the SecurityManager
    System.setSecurityManager(sm);
    
    // Run the user-submitted code here
  }
}