import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import java.io.IOException;

// Example Servlet implementing SingleThreadModel (Deprecated)
public class MyServlet_5 extends HttpServlet implements SingleThreadModel {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Process request
    }

    public static void main(String[] args) {
    }
}