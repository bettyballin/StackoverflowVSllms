import java.lang.String;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/keepAlive")
public class KeepAliveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Simply accessing the session resets its last accessed time
        }
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public static void main(String[] args) {
    }
}