import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;

public class JspToFileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Create a StringWriter to capture the output
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);

            // Get the JspFactory and create PageContext
            JspFactory factory = JspFactory.getDefaultFactory();
            PageContext pageContext = factory.getPageContext(this, request, response,
                    null, false, 8192, true);

            try {
                // Set out to our custom print writer
                pageContext.pushBody(printWriter);
                pageContext.include("/path/to/your/template.jsp");

                // Get the output as a String from StringWriter
                String pageContent = stringWriter.getBuffer().toString();

                // Here you can save it to file or manipulate as needed
                // For example, writing to a file:
                java.nio.file.Files.write(java.nio.file.Paths.get("output.html"), pageContent.getBytes());

            } finally {
                factory.releasePageContext(pageContext);
            }

            // Send the response to the user indicating the file is ready for download
            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=templates.zip");
            // Zip the files and send the zip output stream here
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    public static void main(String[] args) {
    }
}