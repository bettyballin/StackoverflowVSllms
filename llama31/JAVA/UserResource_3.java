import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.lang.String;

@Path("/users/{id}")
public class UserResource_3_3 {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    public Response getUser(@PathParam("id") int id, @Context javax.servlet.http.HttpServletRequest request) {
        // Get the Accept header
        String acceptHeader = request.getHeader("Accept");

        // Determine the response format based on the Accept header
        if (acceptHeader.contains(MediaType.APPLICATION_JSON)) {
            return Response.ok(userToJson(id)).build();
        } else if (acceptHeader.contains(MediaType.TEXT_HTML)) {
            return Response.ok(userToHtml(id)).build();
        } else {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    // Assuming these methods are defined elsewhere in your code
    private String userToJson(int id) {
        // Your implementation here
        return "";
    }

    private String userToHtml(int id) {
        // Your implementation here
        return "";
    }

    public static void main(String[] args) {
    }
}