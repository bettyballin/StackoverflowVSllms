/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class Main_659 {
    public static void main(String[] stringArray) throws NamingException {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        hashtable.put("java.naming.provider.url", "ldap://your-ldap-server:389");
        hashtable.put("java.naming.security.authentication", "simple");
        hashtable.put("java.naming.security.principal", "your-username");
        hashtable.put("java.naming.security.credentials", "your-password");
        InitialDirContext initialDirContext = new InitialDirContext(hashtable);
        String string = "(objectClass=*)";
        String string2 = "dc=example,dc=com";
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(2);
        searchControls.setReturningAttributes(new String[]{"1.1"});
        NamingEnumeration<SearchResult> namingEnumeration = initialDirContext.search(string2, string, searchControls);
        int n = 0;
        while (namingEnumeration.hasMore()) {
            namingEnumeration.next();
            ++n;
        }
        namingEnumeration.close();
        initialDirContext.close();
        System.out.println("Count: " + n);
    }
}
