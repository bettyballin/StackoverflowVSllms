import java.lang.String;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/myresource")
public class MyResource_2_2 {
    @GET
    public Response getResource() {
        DcomObject obj = DcomObjectCache.getInstance().getDcomObject("mykey");
        // use the DCOM object
        DcomObjectCache.getInstance().releaseDcomObject("mykey");
        return Response.ok().build();
    }

    public static void main(String[] args) {
    }
}