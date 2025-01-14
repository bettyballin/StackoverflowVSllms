import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class PdfGeneratorResponseHandler {
    // Example of setting up ByteArrayOutputStream
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // Generate PDF into 'baos'
    byte[] pdfBytes = baos.toByteArray(); // Get byte array after PDF generation
    int fileSize = pdfBytes.length;      // Determine file size

    public void handleResponse(Response response) throws Exception {
        response.setContentType("application/pdf");
        response.setContentLength(fileSize);
        OutputStream o = response.getOutputStream();
        o.write(pdfBytes);
    }

    public static void main(String[] args) throws Exception {
        PdfGeneratorResponseHandler handler = new PdfGeneratorResponseHandler();
        Response response = new Response();
        handler.handleResponse(response);
    }
}

// Dummy 'Response' class to make the code executable
class Response {
    public void setContentType(String type) {
        // Dummy implementation
    }

    public void setContentLength(int length) {
        // Dummy implementation
    }

    public OutputStream getOutputStream() {
        return new ByteArrayOutputStream();
    }
}