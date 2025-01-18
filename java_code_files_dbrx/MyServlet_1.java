import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {

    ArrayList<String> al = null; // create your list as an instance variable

    public void init() throws ServletException {  // initialize the list when this servlet is loaded into memory.
        super.init();
        al = new ArrayList<String>();
        getServletContext().setAttribute("ArrayListExample", al);
    }

    // Inside a service method, create an object and add it to our list
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        String str = "test";
        getServletContext().setAttribute(str, new Object());
        al.add(str);

        // Optionally, you can write a response back to the client
        response.setContentType("text/plain");
        response.getWriter().println("Added 'test' to list and servlet context.");
    }
}