import java.lang.String;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class eDirectoryConnector {
    public static void main(String[] args) {
        String ldapUrl = "ldap://your-edirectory-server-ip:389";
        String baseDn = "o=your-organization";
        String bindDn = "cn=admin,o=your-organization";
        String password = "your-password";

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUrl);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, bindDn);
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            DirContext ctx = new InitialDirContext(env);
            // Perform LDAP operations here, e.g., search, modify, etc.
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}