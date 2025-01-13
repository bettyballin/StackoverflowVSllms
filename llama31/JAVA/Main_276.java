import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class Main_276 {
    public static void main(String[] args) {
        // Assuming you have the DN of the entry you want to delete is 'entryDN'
        String entryDN = "cn=entryDN,ou=people,dc=example,dc=com"; // Example DN

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389"); // Adjust your LDAP server URL
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=example,dc=com"); // Adjust your admin DN
        env.put(Context.SECURITY_CREDENTIALS, "password"); // Adjust your password

        try {
            DirContext ctx = new InitialDirContext(env);
            ctx.unbind(entryDN);
            ctx.close();
        } catch (NamingException e) {
            System.out.println("Error deleting entry: " + e.getMessage());
        }
    }
}