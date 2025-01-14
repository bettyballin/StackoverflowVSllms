import java.lang.String;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.naming.*;
import javax.naming.directory.InitialDirContext;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Hashtable;

public class LDAPSConnectionTest {
    public static void main(String[] args) throws Exception {
        // Load the Java keystore file (change to your path)
        KeyStore ks = KeyStore.getInstance("JKS");
        FileInputStream fis = new FileInputStream("/path/to/keystore.jks");
        ks.load(fis, "password".toCharArray());

        // Load TrustManagerFactory
        String alg = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(alg);
        tmf.init(ks);

        // Initialize SSLContext for our application server port to accept LDAPS connections
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, tmf.getTrustManagers(), null);

        System.setProperty("javax.net.ssl.trustStore", "/path/to/truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        // Specify the LDAP server URL
        String ldapURL = "ldaps://yourServerAddress:636";

        // The environment properties for connecting to the directory service 
        Hashtable<String, Object> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapURL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_SSL_SOCKET_FACTORY, context.getSocketFactory());
        env.put(Context.SECURITY_PRINCIPAL, "uid=yourUsername,cn=users,o=yourOrg"); // Example DN
        env.put(Context.SECURITY_CREDENTIALS, "yourPassword");

        try {
            DirContext ctx = new InitialDirContext(env);
            System.out.println("Connected to LDAP server successfully.");
            ctx.close();
        } catch (NamingException ex) {
            System.err.println("Error connecting to LDAP server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}