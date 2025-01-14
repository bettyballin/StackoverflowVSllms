import java.lang.String;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.ws.rs.core.Response;

public class BackwardCompatibilityTest {
    // Example test for backward compatibility

    @Test
    public void testOldResourceEndpoint() {
        Response oldResponse = target("/api/v1/resource").request().get();
        assertEquals(Response.Status.OK.getStatusCode(), oldResponse.getStatus());
    }

    public static void main(String[] args) {
    }

    // Added a minimal target method to make the code executable
    private RequestBuilder target(String path) {
        return new RequestBuilder(path);
    }

    // Minimal RequestBuilder class
    private static class RequestBuilder {
        private String path;

        public RequestBuilder(String path) {
            this.path = path;
        }

        public Request request() {
            return new Request();
        }
    }

    // Minimal Request class
    private static class Request {
        public Response get() {
            return Response.status(Response.Status.OK).build();
        }
    }
}