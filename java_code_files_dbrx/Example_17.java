import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.InitialDirContext;

public class Example {
    public static void main(String[] args) {
        // Assume ldapUsername has been set already e.g., "user@kerberos.domain"
        String ldapUsername = "user@kerberos.domain";
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.SECURITY_PRINCIPAL, ldapUsername);
        env.put("java.naming.ldap.factory.socket", Krb5SocketFactoryLdap.class.getName());
        try {
            InitialDirContext context = new InitialDirContext(env);
        } catch (javax.naming.AuthenticationException e) { //Kerberos authentication failure handling
            // ....
        } catch (javax.naming.NamingException e) {
            e.printStackTrace();
        }
    }

    static class Krb5SocketFactoryLdap {
        // Implementation goes here
    }
}