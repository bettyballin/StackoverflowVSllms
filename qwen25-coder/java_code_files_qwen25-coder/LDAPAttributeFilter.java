import java.lang.String;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Hashtable;

public class LDAPAttributeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String username = httpRequest.getRemoteUser();

        if (username != null) {
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://your-ldap-server:389/"); // Update with your LDAP server
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=example,dc=com"); // Admin DN
            env.put(Context.SECURITY_CREDENTIALS, "adminpassword"); // Admin password

            try {
                DirContext ctx = new InitialDirContext(env);
                SearchControls searchCtls = new SearchControls();
                searchCtls.setReturningObjFlag(false);
                String[] returnAttrs = {"displayName"};
                searchCtls.setReturningAttributes(returnAttrs);

                NamingEnumeration<SearchResult> answer = ctx.search("dc=example,dc=com", "uid=" + username, searchCtls);
                if (answer.hasMore()) {
                    SearchResult searchResult = answer.next();
                    Attributes attributes = searchResult.getAttributes();
                    Attribute attr = attributes.get("displayName");
                    if (attr != null) {
                        String displayName = (String) attr.get();
                        request.setAttribute("userDisplayName", displayName);
                    }
                }
            } catch (NamingException e) {
                throw new ServletException("Error processing LDAP lookup", e);
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }

	public static void main(String[] args) {
	}
}