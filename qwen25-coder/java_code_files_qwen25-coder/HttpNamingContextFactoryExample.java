import java.lang.String;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HttpNamingContextFactoryExample {
    static {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.HttpNamingContextFactory");
        props.put(Context.PROVIDER_URL, "http://localhost:8080/invoker/JNDIFactory");
    
        try {
            Context ctx = new InitialContext(props);
            // Proceed with JNDI lookups as required
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    }
}