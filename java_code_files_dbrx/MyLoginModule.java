import java.util.Map;
import javax.security.auth.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.callback.*;

public class MyLoginModule implements LoginModule {
    // Implement CallbackHandlers to get credentials for username/password and Kerberos ticket.

    Callback[] callbacks;

    public void initialize(Subject subject, CallbackHandler handler, Map<String,?> sharedState, Map<String,?> options) {
        // initialization code here
    }

    public boolean login() throws LoginException {
        // login code here
        return true;
    }

    public boolean commit() throws LoginException {
        // commit code here
        return true;
    }

    public boolean abort() throws LoginException {
        return false;
    }

    public boolean logout() throws LoginException {
        return true;
    }

    public static void main(String[] args) {
    }
}