import org.ietf.jgss.*;
import javax.security.auth.Subject;
import java.security.AccessController;
import java.security.AccessControlContext;
import java.security.PrivilegedAction;

public class KerberosTicketObtainer {
    private static final Oid KERBEROS_OID = new Oid("1.2.840.113554.1.2.2");

    public void obtainServiceTicket(String serviceName) throws Exception {
        Subject subject = Subject.getSubject(AccessController.getContext()); // Get the authenticated user's credentials
        GSSManager manager = GSSManager.getInstance();

        GSSCredential clientCredentialsElement = null;

        // Obtain the client credentials
        clientCredentialsElement = Subject.doAs(subject, new PrivilegedAction<GSSCredential>() {
            public GSSCredential run() {
                try {
                    return manager.createCredential(null, GSSCredential.DEFAULT_LIFETIME, KERBEROS_OID, GSSCredential.INITIATE_ONLY);
                } catch (GSSException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });

        if (clientCredentialsElement != null) {
            GSSName serverName = manager.createName(serviceName, GSSName.NT_HOSTBASED_SERVICE); // Create the service name in NT_HOSTBASED_SERVICE format
            GSSContext context = manager.createContext(serverName, KERBEROS_OID, clientCredentialsElement, GSSContext.DEFAULT_LIFETIME); // Create a new GSSContext and initiate it with service name and obtained INITIATE credentials
        } else {
            throw new Exception("No Kerberos INITIATE credentials found.");
        }
    }

    public static void main(String[] args) {
    }
}