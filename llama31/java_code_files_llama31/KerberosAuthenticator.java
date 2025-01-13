/*
 * Decompiled with CFR 0.152.
 */
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class KerberosAuthenticator {
    public static void main(String[] stringArray) {
        System.setProperty("java.security.auth.login.config", "jaas.conf");
        try {
            LoginContext loginContext = new LoginContext("Server", new Subject());
            loginContext.login();
            System.out.println("Authenticated");
        }
        catch (LoginException loginException) {
            System.out.println("Authentication failed: " + loginException.getMessage());
        }
    }
}
