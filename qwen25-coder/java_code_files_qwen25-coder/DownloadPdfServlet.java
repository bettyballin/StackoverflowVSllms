// Necessary imports
import java.io.IOException;

public class DownloadPdfServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try (ServletOutputStream out = response.getOutputStream()) {
            // Set the content type and header for PDF
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"HelloWorld.pdf\"");

            // Use the modified method to write the PDF directly to the response output stream
            PrintReportsBean printReportsBean = new PrintReportsBean();
            printReportsBean.writeDownload(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}

// Minimal stub classes to make the code compile

class HttpServlet {
    // Empty class
}

class HttpServletRequest {
    // Empty class
}

class HttpServletResponse {
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream();
    }
    public void setContentType(String type) {}
    public void setHeader(String name, String value) {}
}

class ServletOutputStream implements AutoCloseable {
    @Override
    public void close() throws IOException {
        // Do nothing
    }
}

class PrintReportsBean {
    public void writeDownload(ServletOutputStream out) {
        // Do nothing
    }
}