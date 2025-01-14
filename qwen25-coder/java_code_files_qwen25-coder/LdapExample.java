import javax.naming.Context;
import javax.naming.NameAlreadyBoundException;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

public class LdapExample {
    public static void main(String[] args) {
        // Set up the environment for creating the initial context
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://your-ldap-server:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=example,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "password");

        try {
            // Create the initial context
            LdapContext ctx = new InitialLdapContext(env, null);

            // Define the distinguished name of the entry you want to modify
            String dn = "uid=jdoe,ou=People,dc=example,dc=com";

            // Prepare attributes with multiple values
            BasicAttribute description = new BasicAttribute("description");
            description.add("First Description");
            description.add("Second Description");

            // Specify which attributes to change
            ModificationItem item = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, description);

            // Perform the modify operation
            ctx.modifyAttributes(dn, new ModificationItem[]{item});

            System.out.println("Description attribute updated successfully.");

            // Close the context when we're done
            ctx.close();
        } catch (NameAlreadyBoundException e) {
            System.err.println("Name already exists!");
        } catch (NamingException e) {
            System.err.println("Problem occurred while updating description: " + e);
            e.printStackTrace();
        }
    }
}