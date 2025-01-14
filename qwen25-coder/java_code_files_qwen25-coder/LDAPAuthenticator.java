import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Hashtable;

public class LDAPAuthenticator {

    private static final String LDAP_URL = "ldaps://ldap.example.com";
    private static final String USERNAME_SEARCH_BASE = "ou=users,dc=example,dc=com";

    public static boolean authenticate(String username, String password) throws NamingException {
        Hashtable<String, Object> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "uid=" + username + "," + USERNAME_SEARCH_BASE);
        env.put(Context.SECURITY_CREDENTIALS, password);

        DirContext ctx = new InitialDirContext(env);
        ctx.close(); // if no exception is thrown, authentication succeeded
        return true;
    }

    public static User getUserDetails(String userId) throws NamingException {
        Hashtable<String, Object> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);

        DirContext ctx = new InitialDirContext(env);

        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        String filter = "(uid=" + userId + ")";

        NamingEnumeration<SearchResult> results =
                ctx.search(USERNAME_SEARCH_BASE, filter, controls);

        User user = null;
        if (results.hasMore()) {
            SearchResult searchResult = results.next();
            Attributes attributes = searchResult.getAttributes();

            String firstName = (String) attributes.get("givenName").get();
            String lastName = (String) attributes.get("sn").get();

            user = new User(userId, firstName, lastName);
        }

        results.close();
        ctx.close();
        return user;
    }

    public static class User {
        private final String userId;
        private final String firstName;
        private final String lastName;

        public User(String userId, String firstName, String lastName) {
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // Getters and other methods
    }
}