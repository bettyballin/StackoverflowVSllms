import javax.security.auth.callback.DialogCallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.Subject;
import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosTicket;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSCredential;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;
import java.security.PrivilegedAction;

public class KerberosAuthenticator_1_1 {
    // Exception handling omitted
    LoginContext lc;

    public KerberosAuthenticator_1() throws Exception {
        lc = new LoginContext("HelloEjbClient", new DialogCallbackHandler());
        lc.login();
        Subject.doAs(lc.getSubject(), new PrivilegedAction() {

            public Object run() {
                GSSManager manager = GSSManager.getInstance();
                GSSName clientName = manager.createName("clientUser", GSSName.NT_USER_NAME);
                GSSCredential clientCreds = manager.createCredential(clientName, 8 * 3600, createKerberosOid(), GSSCredential.INITIATE_ONLY);

                GSSName serverName = manager.createName("myService@localhost", GSSName.NT_HOSTBASED_SERVICE);
                GSSContext context = manager.createContext(serverName, createKerberosOid(), null, GSSCredential.DEFAULT_LIFETIME);
                context.requestMutualAuth(true);
                context.requestConf(false);
                context.requestInteg(true);

                byte[] token = new byte[0];
                context.initSecContext(token, 0, token.length);

                // This should obtain the service ticket
                context.getSrcName();

                return null;
            }

            private Oid createKerberosOid() {
                return new Oid("1.2.840.113554.1.2.2");
            }

        });
    }

    public static void main(String[] args) throws Exception {
        new KerberosAuthenticator_1();
    }
}