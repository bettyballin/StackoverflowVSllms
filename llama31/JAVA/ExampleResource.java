import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ExampleResource {
    public Response getExample() {
        // Only application/json is supported
        MediaType supportedType = MediaType.APPLICATION_JSON_TYPE;

        // Evaluate the Accept header
        String acceptHeader = "text/html, text/x-c";
        MediaType[] acceptedTypes = MediaType.parseMediaTypes(acceptHeader);

        // Find the best matching media type
        MediaType bestMatch = null;
        for (MediaType acceptedType : acceptedTypes) {
            if (acceptedType.isCompatible(supportedType)) {
                bestMatch = acceptedType;
                break;
            }
        }

        // If no match is found, return 406 Not Acceptable
        if (bestMatch == null) {
            return Response.status(406).build();
        }

        // Otherwise, return the supported media type
        return Response.ok().type(supportedType).build();
    }

    public static void main(String[] args) {
        ExampleResource resource = new ExampleResource();
        Response response = resource.getExample();
        System.out.println(response.getStatus());
    }
}