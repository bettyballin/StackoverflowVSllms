import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Java Servlet
@WebServlet("/myServlet")
public class MyServlet_7_7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handle GET request
        String data = "Hello from Servlet!";
        resp.getWriter().write(data);
    }

	public static void main(String[] args) {
	}
}