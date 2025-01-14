import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/product/*")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extract product name from path info
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String productName = pathInfo.substring(1); // Remove leading slash
            request.setAttribute("name", productName);

            // Forward to JSP or handle the logic
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/products.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
    }
}