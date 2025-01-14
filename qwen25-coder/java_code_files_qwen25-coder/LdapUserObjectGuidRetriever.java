import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import javax.naming.ldap.*;

public class LdapUserObjectGuidRetriever {

    public String getUserObjectGuid(String username, String password) throws Exception {

        // Setup LDAP context using the provided username/password to authenticate.
        Hashtable<String, String> env = new Hashtable<String, String>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://example.com:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "CN=" + username + ",DC=example,DC=com");
        env.put(Context.SECURITY_CREDENTIALS, password);

        LdapContext ctx = new InitialLdapContext(env, null);

        // Search for user by username to retrieve ObjectGUID
        SearchControls constraints = new SearchControls();
        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<SearchResult> results = ctx.search("DC=example,DC=com",
            "(&(objectClass=user)(sAMAccountName=" + username + "))", constraints);

        if (results.hasMore()) {
            SearchResult searchResult = results.next();
            Attribute objectGUIDAttr = searchResult.getAttributes().get("objectGUID");
            byte[] objectGuid = (byte[]) objectGUIDAttr.get();

            // Convert byte array to hex string for storage
            return bytesToHex(objectGuid);
        }

        ctx.close();
        return null;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
    }
}