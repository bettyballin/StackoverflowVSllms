import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;

public class EDIROLdapSearch {
    public static void main(String[] args) {
        // Set up environment for creating the initial context
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://your.edirectory.server:389/dc=example,dc=com");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=admin,o=novell");
        env.put(Context.SECURITY_CREDENTIALS, "password");

        try {
            // Create the initial directory context
            DirContext ctx = new InitialDirContext(env);

            // Specify search controls
            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            
            // Perform search
            NamingEnumeration<SearchResult> answer = 
                ctx.search("", "(objectClass=*)", ctls);

            // Process results
            while (answer.hasMore()) {
                SearchResult sr = answer.next();
                System.out.println(">> " + sr.getNameInNamespace());
            }

            // Close the context when we're done
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}