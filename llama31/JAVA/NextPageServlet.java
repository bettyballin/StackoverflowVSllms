import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NextPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");

        // Process the parameters as needed
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Param 1: " + param1);
        out.println("Param 2: " + param2);
    }
}