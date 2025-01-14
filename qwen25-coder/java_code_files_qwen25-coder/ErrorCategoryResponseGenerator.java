import java.io.PrintWriter;
import java.io.IOException;
import java.io.StringWriter;

public class ErrorCategoryResponseGenerator {
    // MockResponse class with necessary methods
    static class MockResponse {
        private int status;
        private String contentType;
        private StringWriter stringWriter = new StringWriter();
        private PrintWriter writer = new PrintWriter(stringWriter);

        public void setStatus(int status) {
            this.status = status;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public PrintWriter getWriter() throws IOException {
            return writer;
        }

        // For testing purpose: print the response
        public void flushBuffer() {
            writer.flush();
            System.out.println("Status: " + status);
            System.out.println("Content-Type: " + contentType);
            System.out.println("Response Body: " + stringWriter.toString());
        }
    }

    public static void main(String[] args) {
        // Example response for a non-existent category ID
        MockResponse response = new MockResponse();
        response.setStatus(422);
        response.setContentType("application/json");
        String jsonResponse = "{\"error\":\"The specified category does not exist.\"}";
        try {
            PrintWriter out = response.getWriter();
            out.print(jsonResponse);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // For testing purpose: print the response
        response.flushBuffer();
    }
}