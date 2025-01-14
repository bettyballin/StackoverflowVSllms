import java.lang.String;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Hashtable;

public class LdapSearch {
    public static void main(String[] args) {
        String baseDN = "dc=example,dc=com"; // Define baseDN
        String filter = "(objectClass=*)";   // Define filter

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://your-ldap-server:389"); // Replace with your LDAP server URL
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=YourUsername,cn=Users," + baseDN); // Replace with your username's DN
        env.put(Context.SECURITY_CREDENTIALS, "YourPassword"); // Replace with your password

        try {
            DirContext ctx = new InitialDirContext(env);
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            NamingEnumeration<SearchResult> results = ctx.search(baseDN, filter, searchControls);

            while (results.hasMore()) {
                SearchResult result = results.next();
                System.out.println("Found: " + result.getNameInNamespace());
            }
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}