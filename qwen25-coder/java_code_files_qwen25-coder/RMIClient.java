import java.lang.String;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class RMIClient {
    public static void main(String[] args) throws Exception {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
                      "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "remote://localhost:4447");

        Context ctx = new InitialContext(jndiProps);
        String jndiName = "/<yourAppName>/<beanName>!<fullyQualifiedInterface>";
        MyServiceRemote service = (MyServiceRemote)ctx.lookup(jndiName);

        System.out.println(service.sayHello());
    }
}

interface MyServiceRemote {
    String sayHello();
}