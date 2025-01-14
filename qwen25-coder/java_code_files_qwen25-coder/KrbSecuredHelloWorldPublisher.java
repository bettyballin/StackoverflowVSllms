import java.lang.String;
import javax.xml.ws.Endpoint;
import java.security.Principal;
import javax.security.auth.Subject;
import com.sun.xml.ws.api.security.WSSubject;

public class KrbSecuredHelloWorldPublisher {

    public static void main(String[] args) {
        try {
            // JAX-WS Endpoint publisher, which is secured with JAAS configuration.
            System.setProperty("sun.security.jgss.debug", "true");
            System.setProperty("javax.net.debug", "ssl");

            HelloWorldImpl implementor = new HelloWorldImpl();
            String address = "http://localhost:8091/helloworld";
            Endpoint.publish(address, implementor);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static class HelloWorldImpl implements HelloWorld {

        @Override
        public String sayHello() {
            final Subject subject = WSSubject.getCurrentSubject();
            final Principal principal = subject.getPrincipals().iterator().next();
            return "Hello, " + principal.getName();
        }
    }
    
    public interface HelloWorld {
        String sayHello();
    }
}