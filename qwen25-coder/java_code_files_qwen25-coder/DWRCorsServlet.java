import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dwr/*")
public class DWRCorsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        setAccessControlHeaders(response);
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        setAccessControlHeaders(response);
        super.doPost(request, response);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://applicationA.com");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }

    public static void main(String[] args) {
        // Main method implementation if needed
    }
}