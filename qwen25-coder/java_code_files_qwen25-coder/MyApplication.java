import java.lang.String;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.restlet.resource.ServerResource;

public class MyApplication extends Application {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/myresource", MyResource.class);
        return router;
    }

    public static void main(String[] args) {
    }
}

class MyResource extends ServerResource {
    // Empty class for compilation
}