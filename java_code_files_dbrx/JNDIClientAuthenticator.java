import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;
import javax.security.auth.login.LoginContext;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.Callback;
import java.io.IOException;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import java.security.PrivilegedAction;

public class JNDIClientAuthenticator {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put(Context.SECURITY_PRINCIPAL, "username"); // replace with username
            props.put(Context.SECURITY_CREDENTIALS, "password"); // replace password with user's.
            props.put("jboss.naming.client.ejb.context", true);  // This flag tells JNDI to establish and propagate EJB context for the lookup or method invocation made on returned EJB proxy objects.
            InitialContext ctx = new InitialContext(props);

            // Initialize Login Module, configure it for JAAS login with your configuration "java:/jaas/jboss-secure"
            LoginContext lc = new LoginContext("jaas/myClient", new CallbackHandler() {
                public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
                    for (int i = 0; i < callbacks.length; i++) {
                        if (callbacks[i] instanceof javax.security.auth.callback.NameCallback) {
                            // TODO: Fill Name Callback here accordingly based on your own app requirements.
                        } else if (callbacks[i] instanceof javax.security.auth.callback.PasswordCallback) {
                            // TODO: Fill Password Callback here accordingly based on your own app requirements.
                        } else {
                            throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
                        }
                    }
                }
            });

            try {
                lc.login();
                Subject.doAs(lc.getSubject(), new PrivilegedAction<Object>() {
                    public Object run() {
                        try {
                            return ctx.lookup("DemoServer/MyBean/remote");
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                });
            } finally {
                try {
                    lc.logout();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}