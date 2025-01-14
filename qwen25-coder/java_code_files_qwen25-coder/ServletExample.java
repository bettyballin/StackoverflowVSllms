import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletExample {
    // Example Servlet code snippet
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        RequestContext requestContext = new RequestContext(request);
        request.setAttribute("requestContext", requestContext);
    }

    public static void main(String[] args) {
    }
}