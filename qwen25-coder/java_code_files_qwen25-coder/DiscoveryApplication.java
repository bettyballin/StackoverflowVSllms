import java.lang.String;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class DiscoveryApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        
        // Route to handle GET requests for resource discovery
        router.attach("/discover", DiscoveryServerResource.class);
        
        return router;
    }

    public static class DiscoveryServerResource extends ServerResource {
        
        @Get("xml")
        public Representation represent() {
            // Example XML response with available resources and methods
            String xml = "<resources>"
                    + "<resource path='/users' methods='GET,POST'/>"
                    + "<resource path='/user/{id}' methods='GET,PUT,DELETE'/>"
                    + "</resources>";
            
            return new StringRepresentation(xml);
        }
    }

    public static void main(String[] args) throws Exception {
        // Run the application on port 8182
        org.restlet.Component component = new org.restlet.Component();
        component.getServers().add(org.restlet.data.Protocol.HTTP, 8182);
        component.getDefaultHost().attach(new DiscoveryApplication());
        component.start();
    }
}