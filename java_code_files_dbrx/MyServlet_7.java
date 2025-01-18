import java.io.IOException;

public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/x-server-response");
        /* Disable default encoding handling by container */
        response.setCharacterEncoding(null);
        /** Override existing filter or global charset attribute if any */
        response.addHeader("Content-Type", "application/x-server-response");
    }
}

// Minimal definitions to make the code compile

class HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Empty implementation
    }
}

class HttpServletRequest {
    // Empty class for compilation
}

class HttpServletResponse {
    public void setContentType(String type) {
        // Empty implementation
    }

    public void setCharacterEncoding(String charset) {
        // Empty implementation
    }

    public void addHeader(String name, String value) {
        // Empty implementation
    }
}

class ServletException extends Exception {
    // Empty class for compilation
}