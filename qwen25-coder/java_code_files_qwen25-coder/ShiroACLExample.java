import java.lang.String;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.config.IniSecurityManagerFactory;

public class ShiroACLExample {

    public static void main(String[] args) {
        // Load the shiro.ini configuration
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            currentUser.login(new UsernamePasswordToken("username", "password"));
        }

        // Check ACL using a permission string
        Permission userPermission = new WildcardPermission("user:edit");
        if (currentUser.isPermitted(userPermission)) {
            System.out.println("User is permitted to edit users.");
        } else {
            System.out.println("User is NOT permitted to edit users.");
        }

        // Log out when done
        currentUser.logout();
    }
}