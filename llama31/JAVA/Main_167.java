import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import java.util.Hashtable;

public class Main_167 {
    public static void main(String[] args) throws Exception {
        // Set up the environment for creating the initial context
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "CN=admin,DC=example,DC=com");
        env.put(Context.SECURITY_CREDENTIALS, "password");

        // Create the initial context
        DirContext ctx = new InitialDirContext(env);

        // Specify the base DN and filter for the search
        String baseDN = "DC=example,DC=com";
        String filter = "(memberOf:1.2.840.113556.1.4.1941:=(CN=User1,DC=example,DC=com))";

        // Create the search controls
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(new String[]{"distinguishedName"});

        // Perform the search
        NamingEnumeration<SearchResult> results = ctx.search(baseDN, filter, controls);

        // Process the results
        while (results.hasMore()) {
            SearchResult result = results.next();
            System.out.println(result.getAttributes().get("distinguishedName"));
        }

        // Close the context when we're done
        ctx.close();
    }
}