import java.lang.String;
import com.unboundid.ldap.sdk.*;
import com.unboundid.util.ssl.SSLUtil;
import javax.net.ssl.SSLSocketFactory;

public class ActiveDirectoryAuth {
    public static void main(String[] args) throws Exception {
        String domain = "yourdomain.com";
        String host = domain;
        int port = 636; // LDAPS port
        String username = "testu@yourdomain.com";    // Include the domain in the username format: user@example.com
        String password = "testp";

        LDAPConnection ldapConnection = null;
        try {
            SSLUtil sslUtil = new SSLUtil();
            SSLSocketFactory sslSocketFactory = sslUtil.createSSLSocketFactory();

            // Connect to AD via LDAPS (LDAP protocol with a secure connection)
            ldapConnection = new LDAPConnection(sslSocketFactory, host, port);

            // Build the filter to match the userPrincipalName
            Filter filter = Filter.createEqualityFilter("userPrincipalName", username);

            // Build base DN, e.g., DC=example,DC=com
            String baseDN = "DC=" + domain.replace(".", ",DC=");

            // Build a search request with the base DN and filter
            SearchRequest searchRequest = new SearchRequest(
                baseDN,
                SearchScope.SUB,  // Subtree search scope
                filter
            );

            // Send the request to AD and retrieve the entries
            SearchResult searchResult = ldapConnection.search(searchRequest);

            // Get entries
            if (searchResult.getEntryCount() == 0) {
                throw new Exception("User not found.");
            }

            SearchResultEntry entry = searchResult.getSearchEntries().get(0);

            if (!entry.getDN().isEmpty()) {   // If the entry exists:
                try {
                    // Bind (authenticate) user with username and password
                    ldapConnection.bind(username, password);
                    System.out.println("Authentication successful!");
                } catch (LDAPException e) {
                    throw new Exception("Authentication failed for: " + entry.getDN());
                }
            } else {
                throw new Exception("No results found.");    // No such user exists in the directory
            }
        } catch (LDAPException e) {
            System.err.println("Error connecting to Active Directory: " + host);
            e.printStackTrace();
        } finally {
            if (ldapConnection != null) {   // Always close your connection after use
                ldapConnection.close();
                System.out.println("Disconnected from LDAP Server.");
            }
        }
    }
}