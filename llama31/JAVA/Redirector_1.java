import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Redirector_1_1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String server = request.getServerName();
        String url = "http://" + server + "/store/results/index.jsp";
        response.sendRedirect(url);
    }

    public static void main(String[] args) {
        // This main method is not used in a Servlet context.
        // It's only here to satisfy the compiler.
    }
}