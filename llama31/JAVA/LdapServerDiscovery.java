import java.lang.String;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class LdapServerDiscovery {
    public static void main(String[] args) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://");

        try {
            DirContext ctx = new InitialDirContext(env);
            NamingEnumeration<javax.naming.Binding> bindings = ctx.listBindings("");
            while (bindings.hasMore()) {
                javax.naming.Binding binding = bindings.next();
                System.out.println(binding.getName());
            }
        } catch (NamingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}