import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Use annotation for creating services routes
@Path("/service")
public class ServiceResource_1 {
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  // Supports both XML and JSON response
    public String doGet() {
        // Your implementation here to return XML or JSON
        // For example via JacksonMapper object - jsonOrXmlService.toXML(object)
        return null;
    }

    public static void main(String[] args) {
    }
}