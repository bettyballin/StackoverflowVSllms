import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LdapConnector_1_1 {
    public static void main(String[] args) throws NamingException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldaps://your-ldap-server:636");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "your-username");
        env.put(Context.SECURITY_CREDENTIALS, "your-password");
        env.put("java.naming.security.protocol", "ssl"); // or "tls"

        LdapContext ctx = new InitialLdapContext(env, null);
    }
}