import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DwrServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    response.setHeader("Access-Control-Allow-Origin", "http://example.com");
    // ... other code remains the same ...
  }

  public static void main(String[] args) {
    // This main method is not typically used in servlets but is required for a standalone Java application.
    // For a servlet, initialization and execution are managed by a servlet container like Apache Tomcat.
  }
}