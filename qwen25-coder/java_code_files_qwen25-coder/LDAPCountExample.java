import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

public class LDAPCountExample {
    public static void main(String[] args) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://your-ldap-server:389"); // change this
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=example,dc=com"); // change this
        env.put(Context.SECURITY_CREDENTIALS, "password"); // change this

        try {
            LdapContext ctx = new InitialLdapContext(env, null);
            
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            // request only minimal attributes to minimize data transfer
            String[] attrIDs = {"1.1"}; // 1.1 means no attributes
            searchControls.setReturningAttributes(attrIDs);

            String filter = "(objectClass=*)"; // modify this as per your needs

            NamingEnumeration<SearchResult> results = ctx.search("", filter, searchControls);
            
            int count = 0;
            while (results.hasMore()) {
                results.next();
                count++;
            }
            System.out.println("Total entries: " + count);

            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}