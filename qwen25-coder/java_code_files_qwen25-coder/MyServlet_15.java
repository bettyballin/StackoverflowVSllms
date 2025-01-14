import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        MyClass myClass = new MyClass();
        PrintWriter out = response.getWriter();
        myClass.writeToResponse(out);
    }
}

class MyClass {
    public void writeToResponse(PrintWriter out) {
        // Implementation
    }
}