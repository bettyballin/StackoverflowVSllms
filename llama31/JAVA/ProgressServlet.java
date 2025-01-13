import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet or endpoint to return the progress percentage
@WebServlet("/progress")
public class ProgressServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int progress = 50; // get the progress percentage from your server-side processing
    resp.setContentType("text/plain");
    resp.getWriter().print(progress);
  }

  public static void main(String[] args) {
  }
}