import java.util.Hashtable;
import javax.naming.Context;

public class LDAPConfigurator {
    Hashtable<String, String> ldapEnv;

    public LDAPConfigurator() {
        ldapEnv = new Hashtable<>();
        ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        // specify tls for secure communication
        ldapEnv.put("java.naming.ldap.factory.socket", "javax.net.ssl.SSLSocketFactory");
    }

    public static void main(String[] args) {
    }
}