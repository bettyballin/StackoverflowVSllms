import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/resources")
public class ResourceService {
    @GET
    public Response getResource(@QueryParam("id") Long id) {
        if (id == null) {
            return Response.status(400).build(); // Bad Request
        }
        Resource resource = getResourceFromDatabase(id);
        if (resource == null) {
            return Response.status(404).build(); // Not Found
        }
        return Response.ok(resource).build(); // 200 OK
    }

    @DELETE
    public Response deleteResource(@QueryParam("id") Long id) {
        if (id == null) {
            return Response.status(400).build(); // Bad Request
        }
        deleteResourceFromDatabase(id);
        return Response.noContent().build(); // 204 No Content
    }

    @PUT
    public Response updateResource(@QueryParam("id") Long id, Resource resource) {
        if (id == null) {
            return Response.status(400).build(); // Bad Request
        }
        updateResourceInDatabase(id, resource);
        return Response.ok(resource).build(); // 200 OK
    }

    // Assuming these methods exist in your code
    private Resource getResourceFromDatabase(Long id) {
        // implement database logic here
        return null;
    }

    private void deleteResourceFromDatabase(Long id) {
        // implement database logic here
    }

    private void updateResourceInDatabase(Long id, Resource resource) {
        // implement database logic here
    }

    public static void main(String[] args) {
    }
}

class Resource {
    // implement Resource class here
}