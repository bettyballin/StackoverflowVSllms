import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DynamicFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Generate your dynamic data here
        String dynamicData = "This is some dynamic data";

        // Set the response headers
        resp.setContentType("text/plain"); // or whatever MIME type you need
        resp.setHeader("Content-Disposition", "attachment; filename=\"dynamic_file.txt\"");

        // Write the dynamic data to the response output stream
        resp.getOutputStream().write(dynamicData.getBytes());
        resp.getOutputStream().close();
    }

    public static void main(String[] args) {
    }
}