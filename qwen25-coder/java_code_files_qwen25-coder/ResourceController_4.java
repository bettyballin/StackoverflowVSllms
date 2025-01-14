import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

public class ResourceController_4 {

    private Object resource;

    public ResourceController_4() {
        // Initialize resource
        resource = new Object();
    }

    @GET
    @Path("/resource")
    public Response getResource(@HeaderParam("Accept") String accept) {
        if (accept.contains(MediaType.APPLICATION_JSON)) {
            return Response.ok(new Gson().toJson(resource), MediaType.APPLICATION_JSON).build();
        } else if (accept.contains(MediaType.APPLICATION_XML)) {
            return Response.ok(convertToXml(resource), MediaType.APPLICATION_XML).build();
        } else if (accept.contains(MediaType.TEXT_HTML)) {
            return Response.ok(generateHtml(resource), MediaType.TEXT_HTML).build();
        }
        // Default or error response
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

    private String convertToXml(Object obj) {
        // Dummy implementation
        return "<resource></resource>";
    }

    private String generateHtml(Object obj) {
        // Dummy implementation
        return "<html><body>Resource</body></html>";
    }

    public static void main(String[] args) {
    }
}