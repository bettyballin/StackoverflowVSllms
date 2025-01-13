/*
 * Decompiled with CFR 0.152.
 */
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LdapSearch {
    public static void main(String[] stringArray) {
        try {
            InitialDirContext initialDirContext = new InitialDirContext();
            DirContext dirContext = (DirContext)initialDirContext.lookup("ldap://localhost:389");
            String string = "(objectClass=person)";
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(2);
            NamingEnumeration<SearchResult> namingEnumeration = dirContext.search("dc=example,dc=com", string, searchControls);
            while (namingEnumeration.hasMore()) {
                SearchResult searchResult = namingEnumeration.next();
                System.out.println(searchResult.getName());
            }
        }
        catch (NamingException namingException) {
            System.err.println("NamingException: " + namingException.getMessage());
        }
    }
}
