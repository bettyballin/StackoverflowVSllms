import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TextProcessorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set character encoding to UTF-8
        request.setCharacterEncoding("UTF-8");
        
        String rustext = request.getParameter("rustext");
        // Process the parameter as needed
        
        // Optionally, set response encoding
        response.setContentType("text/html;charset=UTF-8");
    }
    
    public static void main(String[] args) {
    }
}