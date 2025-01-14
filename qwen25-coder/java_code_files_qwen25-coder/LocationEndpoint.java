// Example of a RESTful endpoint handling GET with JSON/XML support

// Define annotations
@interface Path {
    String value();
}

@interface Produces {
    String[] value();
}

@interface GET {}

@interface PathParam {
    String value();
}

// Define MediaType class
class MediaType {
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_ATOM_XML = "application/atom+xml";
}

// Define Response class
class Response {}

// Original class
@Path("/locations/{id}")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
public class LocationEndpoint {

    @GET
    public Response getLocation(@PathParam("id") int id) {
        // Retrieve location data and convert to requested format
        return null;
    }

    public static void main(String[] args) {
    }
}