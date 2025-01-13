import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "TestServlet", urlPatterns = "/engine/*", mimeType = "text/javascript")
public class TestServlet extends HttpServlet {
    // ...

    public static void main(String[] args) {
    }
}