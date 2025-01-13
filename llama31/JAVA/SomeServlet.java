// Define a simple SomeClass for demonstration
class SomeClass {
    private static SomeClass instance;

    public static SomeClass getInstance() {
        if (instance == null) {
            instance = new SomeClass();
        }
        return instance;
    }

    public String doSomething() {
        // For demonstration, this method returns null
        // In a real scenario, implement your logic here
        return null;
    }
}

// Your Servlet class
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class SomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorMessage = SomeClass.getInstance().doSomething();
        if (errorMessage != null) {
            HttpSession session = request.getSession();
            session.setAttribute("error", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        } else {
            String url = response.encodeRedirectURL("index.jsp");
            response.sendRedirect(url);
        }
    }
}