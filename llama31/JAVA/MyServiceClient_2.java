import java.security.Principal;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebService;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.WebMethod;
import javax.xml.ws.security.auth.callback.PasswordCallback;
import javax.xml.ws.security.auth.callback.UsernameCallback;
import javax.xml.ws.handler.MessageContext;

// Client side (using JAX-WS)
@WebService
public class MyServiceClient_2_2 {
    @WebServiceRef
    private MyService service;

    public void callService() {
        // Authenticate using username/password
        Map<String, Object> requestContext = ((BindingProvider) service).getRequestContext();
        requestContext.put(BindingProvider.USERNAME_PROPERTY, "username");
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, "password");

        // Call the service
        service.doSomething();
    }

    public static void main(String[] args) {
        MyServiceClient_2 client = new MyServiceClient_2();
        client.callService();
    }
}

// Server side (using JAX-WS and JBoss WS-Security)
@WebService
@SecurityDomain("jboss-ws-security")
public class MyService {
    @WebMethod
    public void doSomething() {
        // Authenticate and authorize the client
        Principal principal = getSecurityContext().getCallerPrincipal();
        if (principal == null) {
            throw new SecurityException("Authentication failed");
        }
        // Do something
    }

    private javax.xml.ws.security.auth.callback.SecurityContext getSecurityContext() {
        // implementation specific to your environment
        return null;
    }

    public static void main(String[] args) {
    }
}