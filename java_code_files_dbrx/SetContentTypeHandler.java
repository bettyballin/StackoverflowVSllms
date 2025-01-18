public class SetContentTypeHandler {

    public static void main(String[] args) {
        Response response = new Response();

        if (!response.isCommitted()) {
            response.setContentType("image"); // Set your custom content type here
        } else {
            // Take an alternate route or show error message to user indicating that request cannot be processed as expected
        }
    }
}

class Response {
    private boolean committed = false;
    private String contentType = "";

    public boolean isCommitted() {
        return committed;
    }

    public void setContentType(String contentType) {
        if (!committed) {
            this.contentType = contentType;
            System.out.println("Content type set to: " + contentType);
        } else {
            System.out.println("Response already committed. Cannot set content type.");
        }
    }

    // For testing purposes, let's simulate response committing
    public void commit() {
        committed = true;
    }
}