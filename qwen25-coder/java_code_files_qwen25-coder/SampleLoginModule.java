import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class SampleLoginModule implements LoginModule {
    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, ?> sharedState;
    private Map<String, ?> options;
    private boolean loginSucceeded;
    private String username;
    private char[] password;

    @Override
    public void initialize(Subject subject, 
                           CallbackHandler callbackHandler,
                           Map<String, ?> sharedState,
                           Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
        loginSucceeded = false;
    }

    @Override
    public boolean login() throws LoginException {
        if (callbackHandler == null)
            throw new LoginException("no CallbackHandler provided");

        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("prompt:");
        callbacks[1] = new PasswordCallback("prompt:", false);

        try {
            callbackHandler.handle(callbacks);
        } catch (java.io.IOException ioe) {
            throw new LoginException(ioe.toString());
        } catch (UnsupportedCallbackException uce) {
            throw new LoginException(uce.toString() + " "
                    + uce.getCallback().toString());
        }

        username = ((NameCallback) callbacks[0]).getName();
        char[] tmpPassword = ((PasswordCallback) callbacks[1]).getPassword();

        if (tmpPassword == null) {
            password = "".toCharArray();
        } else {
            this.password = new char[tmpPassword.length];
            System.arraycopy(tmpPassword, 0,
                    this.password, 0, tmpPassword.length);
            ((PasswordCallback) callbacks[1]).clearPassword(); // clear the temporary array
        }

        String expectedUsername = (String) options.get("username");
        if (expectedUsername.equals(username)) {
           loginSucceeded = true;
        }
        return loginSucceeded;
    }

    @Override
    public boolean commit() throws LoginException {
        if (!loginSucceeded)
            return false;
        // Add a Principal and Credentials to the Subject
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        // Clean up data used in authentication but not stored in shared state.
        return true;
    }

    @Override
    public boolean logout() throws LoginException {
        // Remove Principals and credentials from the Subject.
        subject.getPrincipals().clear();
        logoutCleanUp();
        loginSucceeded = false;
        return true;
    }

    private void logoutCleanUp() {}

    public static void main(String[] args) {
    }
}