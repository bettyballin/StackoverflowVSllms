import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.security.PrivilegedAction;
import org.ietf.jgss.GSSCredential;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;

public class GssServer {
    public static void main(String[] args) throws Exception {
        // Set the JAAS configuration file location
        System.setProperty("java.security.auth.login.config", "/path/to/your/jaas.conf");

        // Create a LoginContext for the server entry in jaas.conf
        LoginContext context = new LoginContext("server");
        try {
            context.login();  // Log in using keytab, no user interaction
        } catch (LoginException e) {
            throw new RuntimeException("Login failed", e);
        }

        // Get the Subject associated with the authenticated client
        Subject subject = context.getSubject();

        // Perform actions as the authenticated server
        Subject.doAs(subject, new PrivilegedAction<Void>() {
            @Override
            public Void run() {
                try {
                    GSSManager manager = GSSManager.getInstance();
                    Oid krb5Mechanism = new Oid("1.2.840.113554.1.2.2");
                    GSSName gssName = manager.createName(
                            "myserv/mymachine.some.domain@THE.REALM.COM",
                            GSSName.NT_HOSTBASED_SERVICE
                    );
                    GSSCredential serverCreds = manager.createCredential(
                            gssName,
                            GSSCredential.INDEFINITE_LIFETIME,
                            krb5Mechanism,
                            GSSCredential.ACCEPT_ONLY
                    );

                    // Server-side operations here using serverCreds...

                } catch (Exception e) {
                    throw new RuntimeException("Failure to create GSS credential", e);
                }

                return null;
            }
        });

        context.logout();
    }
}