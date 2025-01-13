import java.lang.String;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/myresources")
public class MyResourcesResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MyResource> getResources(@QueryParam("fields") String fields) {
        // Parse fields parameter and filter response accordingly
        // ...
        return filteredResources;
    }

    public static void main(String[] args) {
    }
}