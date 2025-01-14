import java.lang.String;
import javax.xml.bind.annotation.XmlRootElement;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Simple Jackson XmlRootElement class to represent a Location
@XmlRootElement
class Location {
    public String name;
    public double latitude, longitude;

    // No-argument constructor required
    public Location() {}

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

// Automatically convert to JSON or XML based on Accept header
@Path("/locations")
public class LocationsEndpoint {
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
    public Response createLocation(Location location) {
        // Process the data (e.g., save to database)
        return Response.ok().build();
    }

    public static void main(String[] args) {
        // Main method can be empty
    }
}