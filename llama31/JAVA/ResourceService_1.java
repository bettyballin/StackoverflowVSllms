import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/resource")
public class ResourceService_1 {

    @POST
    public Response createResource(Resource resource) {
        if (quotaExceeded()) {
            Response.Status status = Response.Status.BAD_REQUEST;
            Error error = new Error("QUOTA_EXCEEDED", "Quota exceeded");
            return Response.status(status).entity(error).build();
        }
        // ...
        return Response.ok().build(); // Return a default response
    }

    private boolean quotaExceeded() {
        // Implement quota check logic here
        return false;
    }
}

class Error {
    private String code;
    private String message;

    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

class Resource {
    // Add properties and methods for the Resource class
    public Resource() {}
}