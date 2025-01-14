import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AjaxRequestHandler_1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedWith = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(requestedWith)) {
            // The request was made via AJAX
            handleAjaxRequest(request, response);
        } else {
            // The request was not made via AJAX
            handleStandardRequest(request, response);
        }
    }
    
    private void handleAjaxRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Handle the AJAX request
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"message\":\"This is an AJAX request\"}");
        out.flush();
    }
    
    private void handleStandardRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle standard requests
        request.getRequestDispatcher("/standardPage.jsp").forward(request, response);
    }
    
    public static void main(String[] args) {
    }
}