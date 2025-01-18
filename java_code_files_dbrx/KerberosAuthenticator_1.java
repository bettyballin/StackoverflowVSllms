import java.lang.String;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.TextCallbackHandler;
import javax.security.auth.login.LoginContext;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

public class KerberosAuthenticator_1 {

    static {
        System.setProperty("java.security.auth.login.config", "jaas-krb5.conf");
    }

    CallbackHandler handler = new TextCallbackHandler();

    Subject subject;

    {
        try {
            subject = AccessController.doPrivileged(new PrivilegedExceptionAction<Subject>() {
                public Subject run() throws Exception {
                    LoginContext lc = new LoginContext("server", handler);
                    lc.login();
                    return lc.getSubject();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new KerberosAuthenticator_1();
    }
}