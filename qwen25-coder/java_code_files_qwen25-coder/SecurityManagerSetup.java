import java.lang.String;
public class SecurityManagerSetup {
    static {
        System.setProperty("java.security.policy", "file:server.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
    }
    public static void main(String[] args) {
    }
}