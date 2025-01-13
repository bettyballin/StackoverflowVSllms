import java.lang.String;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.kerberos.KerberosTicket;
import com.sun.jndi.ldap.LdapCtxFactory;
import javax.naming.ldap.InitialLdapContext;

public class KerberosTicketRetriever {
    public static void main(String[] args) {
        try {
            // Set up the environment for creating the initial context
            java.util.Hashtable<String, String> env = new java.util.Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, LdapCtxFactory.class.getName());
            env.put(Context.PROVIDER_URL, "ldap://localhost:10389");

            // LoginContext.login() and Subject.doAs()
            LoginContext loginCtx = new LoginContext("your_config_name");
            loginCtx.login();

            // Create the initial context
            LDAPContext ctx = new InitialLdapContext(env, null);

            // Get the service-specific ticket from the subject's private credentials
            KerberosTicket ticket = (KerberosTicket) ctx.getSubject().getPrivateCredentials(KerberosTicket.class).iterator().next();
            System.out.println("Service-specific ticket: " + ticket);
        } catch (LoginException e) {
            System.out.println("Login Exception: " + e.getMessage());
        } catch (NamingException e) {
            System.out.println("Naming Exception: " + e.getMessage());
        }
    }
}