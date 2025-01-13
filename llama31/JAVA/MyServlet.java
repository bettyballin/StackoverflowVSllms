import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Process the request...
    String var1 = "a";
    String var2 = "b";
    
    // Redirect to index.html with variables
    String redirectUrl = "index.html?var1=" + var1 + "&var2=" + var2;
    resp.sendRedirect(redirectUrl);
  }

  public static void main(String[] args) {
  }
}