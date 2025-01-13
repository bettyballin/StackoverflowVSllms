/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;
import javax.naming.NamingEnumeration;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class Main_167 {
    public static void main(String[] stringArray) throws Exception {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        hashtable.put("java.naming.provider.url", "ldap://localhost:389");
        hashtable.put("java.naming.security.authentication", "simple");
        hashtable.put("java.naming.security.principal", "CN=admin,DC=example,DC=com");
        hashtable.put("java.naming.security.credentials", "password");
        InitialDirContext initialDirContext = new InitialDirContext(hashtable);
        String string = "DC=example,DC=com";
        String string2 = "(memberOf:1.2.840.113556.1.4.1941:=(CN=User1,DC=example,DC=com))";
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(2);
        searchControls.setReturningAttributes(new String[]{"distinguishedName"});
        NamingEnumeration<SearchResult> namingEnumeration = initialDirContext.search(string, string2, searchControls);
        while (namingEnumeration.hasMore()) {
            SearchResult searchResult = namingEnumeration.next();
            System.out.println(searchResult.getAttributes().get("distinguishedName"));
        }
        initialDirContext.close();
    }
}
