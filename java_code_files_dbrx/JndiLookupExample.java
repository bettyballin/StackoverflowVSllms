import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JndiLookupExample {
    public static void main(String[] args) {
        try {
            final Hashtable jndiProperties = new Hashtable();
            // Specify any required properties for the Environment. If none, you can leave this block empty.
            // jndiProperties.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapContextFactory"); ...
            Context ctx = new InitialContext(jndiProperties);
            String soapEndpoint = (String) ctx.lookup("/path/to/soap_endpoint");
        } catch (NamingException e) {
            // Handle exception here when unable to find resource or other JNDI related problems.
        }
    }
}