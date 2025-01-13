import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class TestServlet_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        String test = "true"; // equivalent to <s:set var="test" value="%{'true'}"/>
        PrintWriter out = response.getWriter();
        out.println(test); // prints "true"
    }
}