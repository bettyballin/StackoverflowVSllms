import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Dummy classes for missing dependencies

class AbstractView {

    private String contentType;

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    protected void renderMergedOutputModel(
            java.util.Map<String, Object> model,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // Default implementation
    }
}

interface HttpServletRequest {
    // Methods can be added if needed
}

interface HttpServletResponse {
    OutputStream getOutputStream() throws IOException;
}

interface DataHandler {
    DataSource getDataSource();
}

interface DataSource {
    InputStream getInputStream() throws IOException;
}

// Original class

public class PdfView extends AbstractView {

    private DataHandler dataHandler;

    public PdfView(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
        setContentType("application/pdf");
    }

    @Override
    protected void renderMergedOutputModel(
            java.util.Map<String, Object> model,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        DataSource dataSource = dataHandler.getDataSource();
        if (dataSource == null) {
            throw new IllegalArgumentException("No DataHandler specified");
        }
        
        try (OutputStream outputStream = response.getOutputStream()) {
            responseData(dataSource, outputStream);
        }
    }

    private void responseData(DataSource dataSource,
                             OutputStream outputStream) throws IOException {
        try (InputStream inputStream = dataSource.getInputStream()) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        }
    }

    public static void main(String[] args) {
    }
}