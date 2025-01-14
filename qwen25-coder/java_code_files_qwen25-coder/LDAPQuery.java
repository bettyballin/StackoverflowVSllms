import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class LDAPQuery {
    public static void main(String[] args) {
        // Set up environment for creating initial context
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://your-ldap-server:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=mytop,dc=mysuffix");
        env.put(Context.SECURITY_CREDENTIALS, "password");

        try {
            // Create initial context
            DirContext ctx = new InitialDirContext(env);

            // Specify the search base and filter
            String searchBase = "ou=MyOU,dc=mytop,dc=mysuffix";
            String searchFilter = "(objectCategory=group)";

            // Set up search controls
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            // Perform the search
            NamingEnumeration<SearchResult> results = ctx.search(searchBase, searchFilter, searchControls);

            while (results.hasMore()) {
                SearchResult result = results.next();
                System.out.println("Group found: " + result.getNameInNamespace());
            }

            // Close the context when we're done
            ctx.close();

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}