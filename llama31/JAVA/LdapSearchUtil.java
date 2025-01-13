import java.lang.String;

import javax.naming.directory.SearchResponse;
import javax.naming.directory.SearchRequest;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LdapSearchUtil {
    // Retrieve only necessary attributes
    String[] attributes = {"cn", "sn"};
    DirContext connection = new InitialDirContext();

    public static void main(String[] args) {
        LdapSearchUtil util = new LdapSearchUtil();
        SearchRequest searchRequest = null; // You need to initialize this
        util.search(searchRequest);
    }

    public void search(SearchRequest searchRequest) {
        try {
            SearchResponse searchResponse = (SearchResponse) connection.getAttributes(searchRequest, attributes);
            // Handle the search response
        } catch (Exception e) {
            // Handle the exception
        }
    }
}