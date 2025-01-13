import java.lang.String;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class HelloResource_1_1 extends ServerResource {
    @Get
    public String sayHello() {
        return "Hello, World!";
    }

    public static void main(String[] args) throws Exception {
        // Create a new Component.
        Component component = new Component();

        // Add a new HTTP server listening on port 8182.
        component.getServers().add(Protocol.HTTP, 8182);

        // Create an application.
        org.restlet.Application application = new org.restlet.Application() {
            @Override
            public Restlet createInboundRoot() {
                // Create a router
                Router router = new Router(getContext());
                
                // Attach the resource to the router
                router.attach("/hello", HelloResource_1.class);
                
                return router;
            }
        };

        // Attach the application to the component and start it
        component.getDefaultHost().attach(application);
        component.start();
    }
}