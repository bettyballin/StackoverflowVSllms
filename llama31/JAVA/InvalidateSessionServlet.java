import javax.servlet.*;
import java.io.*;

@WebServlet("/invalidate-session")
public class InvalidateSessionServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.invalidate();
  }

	public static void main(String[] args) {
	}
}