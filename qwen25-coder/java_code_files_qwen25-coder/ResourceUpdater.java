import java.lang.String;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public class ResourceUpdater {

    private ResourceService resourceService = new ResourceService();

    @PUT
    @Path("/resource/{id}")
    public Response updateResource(@PathParam("id") String id, Resource resource) {
        // Logic to update the resource
        boolean updated = resourceService.update(id, resource);

        if (updated) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public static void main(String[] args) {
    }
}

class Resource {
    // Resource class definition
}

class ResourceService {
    public boolean update(String id, Resource resource) {
        // Update logic
        return true;
    }
}