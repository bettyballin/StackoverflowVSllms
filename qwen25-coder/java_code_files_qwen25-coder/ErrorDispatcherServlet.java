import java.lang.String;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorDispatcherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the original URL from the request attributes
        String originalURL = (String) request.getAttribute("javax.servlet.error.request_uri");

        if (originalURL == null) {
            originalURL = request.getRequestURI();
        }

        if (originalURL.contains("/admin")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error-admin.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error-user.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

	public static void main(String[] args) {
	}
}