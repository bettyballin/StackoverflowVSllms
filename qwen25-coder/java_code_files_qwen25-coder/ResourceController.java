import java.lang.String;
public class ResourceController {
    public Response deleteResource(String resourceId) {
        if (resourceExists(resourceId)) {
            // Perform actual deletion logic here...
            removeResource(resourceId);
            return new Response().status(Status.NO_CONTENT).build();
        } else {
            return new Response().status(Status.NOT_FOUND).build();
        }
    }

    private boolean resourceExists(String resourceId) {
        // Placeholder implementation
        return true;
    }

    private void removeResource(String resourceId) {
        // Placeholder implementation
    }

    public class Response {
        private Status status;

        public Response status(Status status) {
            this.status = status;
            return this;
        }

        public Response build() {
            // Placeholder implementation
            return this;
        }
    }

    public enum Status {
        NO_CONTENT,
        NOT_FOUND
    }

    public static void main(String[] args) {
    }
}