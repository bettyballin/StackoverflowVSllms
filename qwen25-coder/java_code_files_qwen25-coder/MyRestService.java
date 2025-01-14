import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

// RMI Interface Example
interface MyRemoteInterface extends Remote {
    String doOperation(String param) throws RemoteException;
}

// RESTful Web Service Example using JAX-RS (Jersey)
@Path("/service")
public class MyRestService {

    @GET
    @Path("/operation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doOperation(@QueryParam("param") String param) {
        // Business logic
        return Response.ok("{\"result\": \"" + param.toUpperCase() + "\"}").build();
    }

    public static void main(String[] args) {
    }
}