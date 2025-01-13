import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/myService")
public class MyService_24_24 {
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response myMethod(MyRequest request) {
        // Process the request...
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type")
                .build();
    }

	public static void main(String[] args) {
	}
}

class MyRequest {
    // Add fields and methods for MyRequest class
}