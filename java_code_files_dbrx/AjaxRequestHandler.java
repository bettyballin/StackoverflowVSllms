import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class AjaxRequestHandler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process form data and generate output string
        String output = processFormData(request);

        response.setContentType("text/plain");  // Set the content type to plain text or any other desired MIME type
        response.getWriter().print(output);     // Write the processed result back, which will be sent as a response to the AJAX request made earlier in JavaScript
    }

    private String processFormData(HttpServletRequest request) {
        // Implement the method as needed
        return "";
    }

    public static void main(String[] args) {
    }
}