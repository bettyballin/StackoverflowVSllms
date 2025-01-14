public class JsonServerResource extends ServerResource {

    @Get("json")
    public String represent() {
        // Your JSON generation logic here
        String jsonResponse = "{\"message\":\"Hello, World!\"}";

        // Explicitly set the content type to text/plain for IE compatibility
        getResponse().setMediaType(MediaType.TEXT_PLAIN);
        return jsonResponse;
    }

    public static void main(String[] args) {
        // For testing purposes
        JsonServerResource resource = new JsonServerResource();
        String response = resource.represent();
        System.out.println(response);
    }
}

// Define the Get annotation
@interface Get {
    String value() default "";
}

// Define the MediaType class
class MediaType {
    public static final MediaType TEXT_PLAIN = new MediaType("text/plain");
    private String name;

    public MediaType(String name) {
        this.name = name;
    }
}

// Define the ServerResource class
class ServerResource {
    public Response getResponse() {
        return new Response();
    }
}

// Define the Response class
class Response {
    public void setMediaType(MediaType mediaType) {
        // Method intentionally left blank
    }
}