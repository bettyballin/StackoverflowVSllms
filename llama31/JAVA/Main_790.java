// Import necessary libraries
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class Main_790 {
    public static void main(String[] args) {
        // Create a Shiro security manager
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        // Set the security manager
        SecurityUtils.setSecurityManager(securityManager);

        // Get the current subject (user)
        Subject subject = SecurityUtils.getSubject();

        // Define the username and password
        String username = "your_username";
        String password = "your_password";

        // Authenticate the user
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            System.out.println("Login successful");
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}