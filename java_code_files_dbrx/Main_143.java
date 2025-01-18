import java.util.Hashtable;
import javax.naming.Context;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, String> env = new Hashtable<>();

        // set LDAP server details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "<LDAP SERVER URL>:<PORT>");
        env.put(Context.SECURITY_AUTHENTICATION, "simple"); // LDAP username/password authentication

        // set SSL details
        System.setProperty("javax.net.ssl.trustStore", "<TRUSTSTORE-PATH>");
        System.setProperty("javax.net.ssl.trustStorePassword", "<TRUSTSTORE-PASSWORD>");
        env.put(Context.SECURITY_PROTOCOL, "ssl");  // use SSL protocol for secure connection with LDAP server.
    }
}