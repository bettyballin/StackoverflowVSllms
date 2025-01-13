import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.DirContextFactory;

public class LdapConnectionUtil {
    public static void main(String[] args) {
        // Create an initial directory context
        DirContext ctx = null;
        try {
            ctx = new InitialDirContext();
        } catch (NamingException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        // Create a bind request with a service account
        String bindDn = "cn=service-account,dc=example,dc=com";
        String bindPassword = "password";

        // Bind to the directory
        try {
            ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, bindDn);
            ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, bindPassword);
            ctx.reconnect(null);
        } catch (NamingException e) {
            System.out.println("Error binding to the directory: " + e.getMessage());
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    System.out.println("Error closing the directory context: " + e.getMessage());
                }
            }
        }
    }
}