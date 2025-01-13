import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LdapSearch {
    public static void main(String[] args) {
        try {
            // Set up the LDAP connection
            Context ctx = new InitialDirContext();
            DirContext dirCtx = (DirContext) ctx.lookup("ldap://localhost:389");

            // Define the search filter
            String filter = "(objectClass=person)";

            // Perform the search
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> results = dirCtx.search("dc=example,dc=com", filter, controls);

            // Print the results
            while (results.hasMore()) {
                SearchResult result = results.next();
                System.out.println(result.getName());
            }
        } catch (NamingException e) {
            System.err.println("NamingException: " + e.getMessage());
        }
    }
}