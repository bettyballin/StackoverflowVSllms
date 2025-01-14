import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

public class MySessionServlet extends HttpServlet {
    // This is an example using Java servlets
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("newAttribute", "value");
        // Optionally, send a response back to the client if needed
    }
    
    public static void main(String[] args) {
    }
}