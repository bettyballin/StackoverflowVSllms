import javax.naming.directory.SearchRequest;
import javax.naming.directory.SearchScope;

public class LdapUsernameSearcher {
    public static void main(String[] args) {
        String username = "exampleUsername"; // define the username to search for
        SearchRequest searchRequest = new SearchRequest("dc=example,dc=com", "(uid=" + username + ")", SearchScope.SUBTREE);
    }
}