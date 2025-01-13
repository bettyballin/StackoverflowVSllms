import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/alternate/uri")
public class AlternateUriResource {
    @GET
    public Response getAlternateUri() {
        URI canonicalUri = UriBuilder.fromUri("/canonical/uri").build();
        return Response.seeOther(canonicalUri).build();
    }

    public static void main(String[] args) {
    }
}