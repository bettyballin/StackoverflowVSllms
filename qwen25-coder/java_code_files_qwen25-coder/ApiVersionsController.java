public class ApiVersionsController {
    // Example endpoint for both versions
    @GET("/api/v1/resource")
    public Response oldResourceVersion() {
        return null;
    }

    @GET("/api/v2/resource")
    public Response newResourceVersion() {
        return null;
    }

    public static void main(String[] args) {
    }
}

// Define the @GET annotation
@interface GET {
    String value();
}

// Define the Response class
class Response {
}