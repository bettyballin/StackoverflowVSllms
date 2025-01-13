import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class TestServlet_1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String test = "true";
        request.setAttribute("test", test);

        PrintWriter out = response.getWriter();
        out.println(test); // prints "true"
    }
}