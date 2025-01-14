import java.io.IOException;
import java.io.PrintWriter;

// Dummy exception class to replace ServletException
class ServletException extends Exception {
    public ServletException(String message) {
        super(message);
    }
}

// Dummy HttpServlet class
class HttpServlet {
    // You can add methods if needed
}

// Dummy HttpServletRequest class
class HttpServletRequest {
    public String getParameter(String key) {
        // For testing purposes, return a sample value
        return "ETC"; // Replace with desired test value
    }
}

// Dummy HttpServletResponse class
class HttpServletResponse {
    public void setContentType(String type) {
        // Do nothing
    }

    public PrintWriter getWriter() {
        return new PrintWriter(System.out);
    }
}

public class MyServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = "yourParameterName"; // Replace with the actual parameter name
        String selectedValue = request.getParameter(key);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if ("ETC".equals(selectedValue)) {
            out.println("<p style='color:red;'>Please select a valid option.</p>");
        } else if (selectedValue != null) {
            // Process the form submission
        }
        out.flush();
    }

    public static void main(String[] args) throws IOException, ServletException {
        MyServlet servlet = new MyServlet();
        HttpServletRequest request = new HttpServletRequest();
        HttpServletResponse response = new HttpServletResponse();
        servlet.doGet(request, response);
    }
}