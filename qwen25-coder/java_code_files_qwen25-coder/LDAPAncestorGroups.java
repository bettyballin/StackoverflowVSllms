import javax.naming.*;
import javax.naming.directory.*;
import java.util.*;

public class LDAPAncestorGroups {
    public static Set<String> getAllAncestorGroups(String userDN) throws NamingException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://your.server.com/baseDN");

        DirContext ctx = new InitialDirContext(env);

        // Search user's direct groups
        Attributes attrs = ctx.getAttributes(userDN, new String[]{"memberOf"});
        Attribute memberOfAttr = attrs.get("memberOf");
        Queue<String> queue = new LinkedList<>();
        Set<String> allGroups = new HashSet<>();

        if (memberOfAttr != null) {
            for (NamingEnumeration<?> values = memberOfAttr.getAll(); values.hasMoreElements();) {
                String groupDN = (String) values.next();
                queue.add(groupDN);
            }
        }

        while (!queue.isEmpty()) {
            String currentGroupDN = queue.poll();

            if (!allGroups.contains(currentGroupDN)) { // Avoid duplicates
                allGroups.add(currentGroupDN);
                SearchControls sc = new SearchControls();
                sc.setSearchScope(SearchControls.OBJECT_SCOPE);

                // Find all parent groups of the current group
                NamingEnumeration<SearchResult> results = ctx.search("",
                    "(&(distinguishedName=" + escapeLDAPSearchFilter(currentGroupDN) + ")(memberOf=*))", sc);

                while (results.hasMore()) {
                    SearchResult sr = results.next();
                    Attribute parentsAttr = sr.getAttributes().get("memberOf");

                    if (parentsAttr != null) {
                        for (NamingEnumeration<?> parentValues = parentsAttr.getAll(); parentValues.hasMoreElements();) {
                            String parentDN = (String) parentValues.next();
                            if (!allGroups.contains(parentDN)) { // Avoid duplicates
                                queue.add(parentDN);
                            }
                        }
                    }
                }
            }
        }

        ctx.close();
        return allGroups;
    }

    /**
     * Escapes LDAP search filter syntax.
     */
    private static String escapeLDAPSearchFilter(String filter) {
        StringBuilder sb = new StringBuilder(filter.length());
        for (char c : filter.toCharArray()) {
            switch(c) {
                case '\\': sb.append("\\5c"); break;
                case '*':  sb.append("\\2a"); break;
                case '(':  sb.append("\\28"); break;
                case ')':  sb.append("\\29"); break;
                case '\0': sb.append("\\00"); break;
                default:   sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Set<String> groups = getAllAncestorGroups("CN=johndoe,CN=Users,DC=example,DC=com");
        for (String group : groups) {
            System.out.println(group);
        }
    }
}