import java.lang.String;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import java.util.Hashtable;

public class LDAPQueryExample {
    public static void main(String[] args) {
        String ldapUri = "ldap://localhost:389";
        String searchBase = "dc=example,dc=com";

        Hashtable<String, Object> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUri);
        
        // Optionally set security credentials if required
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "uid=admin,dc=example,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "secret");

        DirContext ctx;
        try {
            ctx = new InitialDirContext(env);
                
            SearchControls searchCtls = new SearchControls();
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            // The filter to find all users in the directory
            String searchFilter = "(objectClass=person)";
                
            // Perform the actual search and display results
            NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter, searchCtls);
            while (answer.hasMoreElements()) {
                SearchResult sr = answer.nextElement();
                System.out.println(">> " + sr.getName()); // Print out each entry DN
            }
                
            ctx.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}