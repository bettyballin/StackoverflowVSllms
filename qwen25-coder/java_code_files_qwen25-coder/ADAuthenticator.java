import java.lang.String;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class ADAuthenticator {

    public static boolean authenticate(String username, String password) {
        // Active Directory server URL (replace with your LDAP server)
        String ldapURL = "ldaps://fun.xyz.tld:636";

        // The base DN for your directory, usually something like DC=yourdomain,DC=com
        // Not required for simple bind operation
        String domainName = "@fun.xyz.tld";
        
        // Complete user principal name
        String userPrincipalName = username + domainName;

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapURL);
        
        // Simple bind operation with the distinguished name and password
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, userPrincipalName);
        env.put(Context.SECURITY_CREDENTIALS, password);

        DirContext ctx = null;
        try {
            ctx = new InitialDirContext(env);
            // If we reach here without exceptions then the bind was successful.
            // Authentication is successful
            return true;
        } catch (NamingException e) {
            // Authentication failed
            return false;
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException ne) {}
            }
        }
    }

    public static void main(String[] args) {
        String username = "testu";
        String password = "testp";

        boolean isAuthenticated = authenticate(username, password);
        if (isAuthenticated) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}