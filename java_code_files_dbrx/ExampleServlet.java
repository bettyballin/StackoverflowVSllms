import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ExampleServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setBufferSize(8192); // Set an appropriate buffer size
        PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"), true);
        out.print("<h1>My example</h1>");
        // perform other operations here, before committing the response:
        response.flushBuffer(); // This makes sure that all bytes of the buffer are sent to client side
    }

}