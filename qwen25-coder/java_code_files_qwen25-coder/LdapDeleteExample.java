import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class LdapDeleteExample {
    public static void main(String[] args) {
        // LDAP server details
        String ldapURL = "ldap://ldap.example.com:389";
        String adminDN = "cn=admin,dc=example,dc=com";
        String password = "adminpassword";

        // DN of the entry to delete
        String dnToDelete = "uid=john.doe,ou=users,dc=example,dc=com";

        // Set up environment for creating the initial context
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapURL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, adminDN);
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            // Create the initial directory context
            DirContext ctx = new InitialDirContext(env);

            // Delete the entry
            ctx.destroySubcontext(dnToDelete);

            System.out.println("LDAP entry deleted successfully.");

            // Close the context when we're done
            ctx.close();
        } catch (NamingException e) {
            System.err.println("Failed to delete LDAP entry: " + e);
        }
    }
}