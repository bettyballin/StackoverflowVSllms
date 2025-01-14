import java.io.IOException;

public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

        // Retrieve the parameters from the request object
        String username = (String) request.getAttribute("txtUsername");
        String name = (String) request.getAttribute("txtName");
        String password = (String) request.getAttribute("txtPassword");

        // Here you can use these parameters as needed
    }
}

// Define HttpServlet
class HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // Empty implementation
    }
}

// Define HttpServletRequest
class HttpServletRequest {
    public Object getAttribute(String name) {
        // Return a dummy value or null
        return null;
    }
}

// Define HttpServletResponse
class HttpServletResponse {
    // Empty implementation
}

// Define ServletException
class ServletException extends Exception {
    // Empty implementation
}