import java.lang.String;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dataServlet")
public class DataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String responseData = "Hello from servlet!";
        response.setContentType("application/json");
        response.getWriter().write(responseData);
    }

	public static void main(String[] args) {
	}
}