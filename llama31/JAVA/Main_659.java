import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;

public class Main_659 {
    public static void main(String[] args) throws NamingException {
        // Initialize LDAP context
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://your-ldap-server:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "your-username");
        env.put(Context.SECURITY_CREDENTIALS, "your-password");

        DirContext ctx = new InitialDirContext(env);

        // Set search filter and base DN
        String filter = "(objectClass=*)"; // your LDAP filter
        String baseDN = "dc=example,dc=com"; // your base DN

        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(new String[] {"1.1"}); // this is the magic attribute that retrieves only the count

        NamingEnumeration<SearchResult> results = ctx.search(baseDN, filter, controls);

        int count = 0;
        while (results.hasMore()) {
            results.next();
            count++;
        }
        results.close(); // Close the NamingEnumeration to free resources

        ctx.close(); // Close the DirContext to free resources

        System.out.println("Count: " + count);
    }
}