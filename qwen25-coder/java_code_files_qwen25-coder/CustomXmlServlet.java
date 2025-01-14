import java.lang.String;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomXmlServlet", urlPatterns = {"*.xml"})
public class CustomXmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo() != null ? request.getPathInfo() : "";

        // Check if the request URI starts with "/prefix_"
        if (pathInfo.startsWith("/prefix_")) {
            // Handle your specific processing here
            response.getWriter().write("Handled by CustomXmlServlet for: " + pathInfo);
        } else {
            // Forward to the default servlet
            RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("default");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Default handler not found.");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // delegate POST to GET for demonstration purposes
    }

	public static void main(String[] args) {
	}
}