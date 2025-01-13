import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class Main_319 {
    public static void main(String[] args) {
        String username = "your_username";
        String password = "your_password";

        Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        p.put(Context.PROVIDER_URL, "jnp://localhost:1099/");

        LoginContext loginContext = new LoginContext("jboss-secure", new UsernamePasswordHandler(username, password));
        try {
            loginContext.login();
        } catch (LoginException e) {
            // handle login exception
            System.out.println("Login failed: " + e.getMessage());
            return;
        }

        try {
            InitialContext ctx = new InitialContext(p);
            MyBeanRemote ejb = (MyBeanRemote) ctx.lookup("DemoServer/MyBean/remote");
            // Use the ejb, for example, call a method on it
            String result = ejb.exampleMethod();
            System.out.println("Result from EJB method call: " + result);
        } catch (Exception e) {
            // handle exception
            System.out.println("Lookup failed: " + e.getMessage());
        }
    }
}

class UsernamePasswordHandler implements javax.security.auth.callback.CallbackHandler {
    private String username;
    private String password;

    public UsernamePasswordHandler(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void handle(javax.security.auth.callback.Callback[] callbacks) throws javax.security.auth.callback.UnsupportedCallbackException {
        for (javax.security.auth.callback.Callback callback : callbacks) {
            if (callback instanceof javax.security.auth.callback.NameCallback) {
                ((javax.security.auth.callback.NameCallback) callback).setName(username);
            } else if (callback instanceof javax.security.auth.callback.PasswordCallback) {
                ((javax.security.auth.callback.PasswordCallback) callback).setPassword(password.toCharArray());
            } else {
                throw new javax.security.auth.callback.UnsupportedCallbackException(callback);
            }
        }
    }
}

interface MyBeanRemote {
    // Define an example method
    String exampleMethod();
}