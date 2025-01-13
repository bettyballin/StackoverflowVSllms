import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class SearchServlet extends HttpServlet {
    // in your servlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // process form data...
      String results = "Your search results here";
      response.setContentType("text/plain");
      response.getWriter().write(results);
    }

    public static void main(String[] args) {
    }
}