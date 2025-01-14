import java.lang.String;
import java.lang.Set;
import java.io.*;

public class ExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get the ServletContext object
        ServletContext application = getServletContext();

        // Set an attribute in the ServletContext (similar to application.setAttribute in JSP)
        application.setAttribute("sharedVar", "This is a shared value");

        // Retrieve an attribute from the ServletContext (similar to application.getAttribute in JSP)
        String value = (String) application.getAttribute("sharedVar");

        // Write response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>Shared Variable: " + value + "</p>");
        out.println("</body></html>");
    }

    public static void main(String[] args) throws Exception {
        ExampleServlet servlet = new ExampleServlet();
        HttpServletRequest request = new HttpServletRequest();
        HttpServletResponse response = new HttpServletResponse();
        servlet.doGet(request, response);
    }
}

// Stub classes to make the code executable

class ServletException extends Exception {
    public ServletException() { super(); }
    public ServletException(String message) { super(message); }
    public ServletException(String message, Throwable cause) { super(message, cause); }
    public ServletException(Throwable cause) { super(cause); }
}

class ServletContext {
    private java.util.HashMap<String, Object> attributes = new java.util.HashMap<String, Object>();
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }
    public Object getAttribute(String name) {
        return attributes.get(name);
    }
}

class HttpServletRequest {
    // Stub implementation
}

class HttpServletResponse {
    private java.io.PrintWriter writer;
    public HttpServletResponse() {
        // Output to console
        writer = new java.io.PrintWriter(System.out, true);
    }
    public void setContentType(String contentType) {
        // Stub implementation
    }
    public java.io.PrintWriter getWriter() throws IOException {
        return writer;
    }
}

class HttpServlet {
    private ServletContext servletContext = new ServletContext();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Stub implementation
    }
    public ServletContext getServletContext() {
        return servletContext;
    }
}