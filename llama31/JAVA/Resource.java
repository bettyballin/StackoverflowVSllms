import java.lang.String;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Resource {
    @Path("/resource")
    public class ResourceClass {
        @GET
        @Produces(MediaType.APPLICATION_XML)
        public Response getResource() {
            // Return the resource data in XML format
            return Response.ok("<data><id>1</id><name>John</name></data>").build();
        }
    }

    public static void main(String[] args) {
        // A client can consume the API without understanding the semantic meaning of the data
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://example.com/resource").request().get();
        String xmlData = response.readEntity(String.class);
        // Process the XML data without knowing its semantic meaning
        System.out.println(xmlData);
    }
}