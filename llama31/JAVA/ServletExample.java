import javax.servlet.http.HttpServletResponse;

public class ServletExample {
    public void doGet(HttpServletResponse response) {
        response.setContentType("application/x-server-response");
    }
}