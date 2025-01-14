import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class EJBClient {

    public static void main(String[] args) {
        String username = "yourUsername";
        char[] password = "yourPassword".toCharArray();

        try {
            // Initialize the LoginContext with the name of the security domain and an instance of your callback handler
            LoginContext lc = new LoginContext("jboss-secure", new MyCallbackHandler(username, password));
            
            // Perform authentication
            lc.login();

            Properties p = new Properties();
            p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
            p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
            p.put(Context.PROVIDER_URL, "jnp://localhost:1099/");

            InitialContext ctx = new InitialContext(p);
            MyBeanRemote ejb = (MyBeanRemote) ctx.lookup("DemoServer/MyBean/remote");

            // Call business methods
            if (lc.getSubject().isReadOnly()) {
                System.out.println("Subject is read-only.");
            }

        } catch (LoginException e) {
            System.err.println("Authentication failed: " + e.getMessage());
        } catch (NamingException e) {
            System.err.println("Could not lookup EJB: " + e.getMessage());
        }
    }
}

class MyCallbackHandler implements CallbackHandler {
    private String username;
    private char[] password;

    public MyCallbackHandler(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public void handle(Callback[] callbacks) {
        for (Callback callback : callbacks) {
            if (callback instanceof NameCallback) {
                NameCallback nc = (NameCallback) callback;
                nc.setName(username);
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback pc = (PasswordCallback) callback;
                pc.setPassword(password);
            } else {
                // Handle other types of Callbacks if necessary
            }
        }
    }
}

interface MyBeanRemote {
    // Define business methods as needed
}