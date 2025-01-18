import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;

public class GroupHierarchy {
    public static void main(String[] args) {
        String baseDN = "dc=example,dc=com";
        String samAccountName = "joohnDoE";

        try {
            // Set up the environment for creating the initial context
            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://ldap.example.com:389");

            // Authenticate as yourself, or an application
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, "cn=admin," + baseDN);
            env.put(Context.SECURITY_CREDENTIALS, "password");

            // Create the initial context
            DirContext ctx = new InitialDirContext(env);

            // Perform search for the user
            String searchFilter = "(samaccountname=" + samAccountName + ")";
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            NamingEnumeration<SearchResult> results = ctx.search(baseDN, searchFilter, searchControls);

            String userDN = null;
            if (results.hasMore()) {
                SearchResult searchResult = results.next();
                userDN = searchResult.getNameInNamespace();
            } else {
                System.out.println("User not found.");
                return;
            }

            Set<String> visitedGroups = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            Set<String> allGroups = new HashSet<>();

            queue.add(userDN);

            while (!queue.isEmpty()) {
                String currentGroupDN = queue.poll();

                // Add group to results if it's a unique visited group.
                if(!visitedGroups.contains(currentGroupDN) && !allGroups.contains(currentGroupDN)) {
                    allGroups.add(currentGroupDN);
                }

                visitedGroups.add(currentGroupDN);

                // Get the parent groups of current group from LDAP. This might be empty if it's a top-level group.
                Attributes attrs = ctx.getAttributes(currentGroupDN, new String[]{"memberOf"});
                Attribute memberOf = attrs.get("memberOf");

                if (memberOf != null) {
                    NamingEnumeration<?> groups = memberOf.getAll();
                    while (groups.hasMore()) {
                        String groupDN = (String) groups.next();
                        // Enqueue this parent group only if we haven't visited yet.
                        if (!visitedGroups.contains(groupDN)) {
                            queue.add(groupDN);
                        }
                    }
                }
            }

            // Output the groups
            System.out.println("All Groups:");
            for (String group : allGroups) {
                System.out.println(group);
            }

            // Close the context when we're done
            ctx.close();

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}