import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

public class MyServlet_12_12 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param1 = req.getParameter("param1");
        String param2 = req.getParameter("param2");

        // perform the computation
        byte[] result = compute(param1, param2);

        // write the result directly to the response.
        resp.getOutputStream().write(result);
    }

    private byte[] compute(String param1, String param2) {
        // do the computation here and return the result
        return null; // You need to implement the computation logic here
    }

    public static void main(String[] args) {
        // You need to implement a way to run the servlet, 
        // or remove the main method if it's not needed.
    }
}