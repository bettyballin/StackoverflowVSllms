import javax.servlet.http.HttpServletResponse;

public class PdfResponse {
    public void setPdfResponse(HttpServletResponse response) {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"yourfile.pdf\"");
        // write the PDF file to the response output stream
    }
}