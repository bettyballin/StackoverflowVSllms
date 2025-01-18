import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet; // import the WebServlet annotation
import javax.servlet.http.HttpServlet; // import HttpServlet
import javax.servlet.http.HttpServletRequest; // import HttpServletRequest
import javax.servlet.http.HttpServletResponse; // import HttpServletResponse

@WebServlet("/HelloWorld") // define Servlet URL pattern to reach this class using http://localhost:8080/.../HelloWorld request
public class HelloWorld_5 extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
    PrintWriter out = resp.getWriter(); // get writer response object (stream) where we can start putting http content
    out.println("Hello"); // write plain text as HTTP response to the browser/console that requested HelloWorld URL pattern
  }

  public static void main(String[] args) {
  }
}