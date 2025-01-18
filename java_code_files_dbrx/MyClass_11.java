import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.callback.CallbackHandler;
import org.apache.geronimo.gshell.console.LoginManager;
import org.eclipse.jetty.jaas.JAASLoginService;
import org.eclipse.jetty.server.UserIdentity;

public class MyClass {

    public Subject getSubjectFromUsername(String username) throws Exception {
        JAASLoginService jaas = (JAASLoginService) LoginManager.getRealm().getAuthenticationStore(); // assuming you initialized the LoginManager correctly, of course!
    
        // Assuming an Active Directory realm configuration with a specific search filter: (&(uid=%v)(objectClass=inetOrgPerson))
        UserIdentity user = jaas.loadUserIdentity("AD", username);

        // If no subject is found, you can return null or throw an Exception
        if (user == null) {
            throw new IllegalArgumentException("No user with given username " + username);
        }

        Subject jaasSubject = new Subject();
        // We need to create a LoginContext, assuming a callback handler
        CallbackHandler callbackHandler = new CallbackHandler() {
            public void handle(javax.security.auth.callback.Callback[] callbacks) {
                // implementation
            }
        };
        LoginContext loginContext = new LoginContext("LoginModuleName", jaasSubject, callbackHandler);

        loginContext.login();

        return jaasSubject; // Contains Roles/Principals in case of Successful Authentication; null otherwise
    }
}