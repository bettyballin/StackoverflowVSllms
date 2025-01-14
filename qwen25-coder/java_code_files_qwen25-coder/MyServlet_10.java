import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();

        String errorMessage = SomeClass.getInstance().doSomething();
        if (errorMessage != null) {
            session.setAttribute("error", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        } else {
            String url = response.encodeRedirectURL("index.jsp");
            response.sendRedirect(url);
        }
    }
}

class SomeClass {
    private static SomeClass instance = new SomeClass();

    private SomeClass() {
        // Constructor
    }

    public static SomeClass getInstance() {
        return instance;
    }

    public String doSomething() {
        // Implementation here
        return null;
    }
}