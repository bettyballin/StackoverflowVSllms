import javax.security.auth.login.Configuration;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;

public class KerberosAuthenticator {
    public static void main(String[] args) {
        System.setProperty("java.security.auth.login.config", "jaas.conf");

        try {
            LoginContext loginContext = new LoginContext("Server", new Subject());
            loginContext.login();
            System.out.println("Authenticated");
        } catch (LoginException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}