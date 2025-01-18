import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

public class Main {
    public static void main(String[] args) {
        LdapContext ctx = null; // get your initialized ldap context here
        String filter = "(your-search-filter)"; // replace with your actual search filter;
        int maxCountLimit = 100_000; // limit the result count to improve performance. Adjust this value as needed.
        try {
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE); // or whatever search scope you need: OBJECT_SCOPE, ONELEVEL_SCOPE
            controls.setCountLimit(maxCountLimit); // request count up to max limit only, without actual objects
            controls.setReturningAttributes(new String[0]); // empty result will optimize performance while counting entries
            NamingEnumeration<SearchResult> searchResults = ctx.search("", filter, controls); // perform the LDAP query

            int count = 0;
            while (searchResults != null && searchResults.hasMoreElements()) {
                count++; // increment counter for each entry found - this will give you the total matching entries count up to maxLimitCount
                if (count > maxCountLimit) { // in case your limit is reached and still more matches, inform that result might be partial due to limit
                    System.out.println("Note: Count result may not reflect all actual existing matches since 'returnedObjFlag' was set to false.");
                }
                searchResults.next(); // Move to the next search result to avoid an infinite loop
            }
        } catch (NamingException e) {
            // handle naming exception here
        } finally {
            // clean up resources if necessary
        }
    }
}