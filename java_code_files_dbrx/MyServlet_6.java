import java.io.IOException;
import java.util.List;

public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = fetchStudents();
        request.setAttribute("students", students);

        // Forward request to desired JSP file for view rendering with EL expressions
        RequestDispatcher rd = request.getRequestDispatcher("/displayStudents.jsp");
        rd.forward(request, response);
    }

    private List<Student> fetchStudents() {
        // fetch the required student objects
        return null;
    }
}

class Student {
    // Student class definition
}

// Minimal definitions of required classes and interfaces

// ServletException class
class ServletException extends Exception {
    public ServletException() {}
    public ServletException(String message) { super(message); }
    public ServletException(String message, Throwable cause) { super(message, cause); }
    public ServletException(Throwable cause) { super(cause); }
}

// RequestDispatcher interface
interface RequestDispatcher {
    void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

// HttpServlet class
class HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}

// HttpServletRequest interface
interface HttpServletRequest {
    void setAttribute(String name, Object o);
    RequestDispatcher getRequestDispatcher(String path);
}

// HttpServletResponse interface
interface HttpServletResponse {
}