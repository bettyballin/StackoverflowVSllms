import java.security.Permission;
import java.lang.SecurityManager;

// Define custom permission for your specific API functionality
class MyAPISecurityPermission extends Permission {

    public MyAPISecurityPermission(String name) {
        super(name);
    }

    @Override
    public boolean implies(Permission p) {
        if (!(p instanceof MyAPISecurityPermission)) return false;
        MyAPISecurityPermission that = (MyAPISecurityPermission) p;
        // Check permission name logic here
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyAPISecurityPermission)) return false;
        MyAPISecurityPermission that = (MyAPISecurityPermission) obj;
        return getName().equals(that.getName());
    }

    @Override
    public String getActions() {
        // Action details can be defined here
        return "";
    }
}

// Usage of SecurityManager to enforce permissions
class CustomSecurityManager extends SecurityManager {

    @Override
    public void checkPermission(Permission perm) {
        if (!(perm instanceof MyAPISecurityPermission)) {
            throw new SecurityException("Unauthorized access");
        }
        super.checkPermission(perm);
    }

    // You can override other methods like checkRead, checkWrite etc. for additional control
}

// Main class to set the security manager and run scripts
public class ScriptRunner {

    public static void main(String[] args) {
        System.setSecurityManager(new CustomSecurityManager());

        // Use your scripting engine of choice here (JRuby, Groovy, Jython etc.)
        // Make sure to grant MyAPISecurityPermission in the security policy for your API methods
    }
}